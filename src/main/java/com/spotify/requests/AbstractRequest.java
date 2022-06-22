package com.spotify.requests;

import com.spotify.exceptions.SpotifySerializationException;
import com.spotify.json.JSONArray;
import com.spotify.json.JSONObject;
import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.requests.util.ParameterPair;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * The base of the API requests
 */
public abstract class AbstractRequest<T extends Serializable> implements IRequest, Serialize<T>, Serializable {


    private final static String BASE_URL = "https://api.spotify.com/v1/";
    private final static HttpClient httpClient = HttpClientBuilder.create().build();
    private final Map<String, RequestQuery<?>> queries;
    private final Map<String, Class<?>> restrictedQueryTypes;

    public AbstractRequest() {
        this.queries = new HashMap<>();
        this.restrictedQueryTypes = new HashMap<>();
    }

    /**
     * @param entries The parameter keys that are allowed on the specific request
     */
    public AbstractRequest(ParameterPair... entries) {
        this();
        for (ParameterPair entry : entries) {
            this.restrictedQueryTypes.put(entry.getKey(), entry.getClassType());
        }
    }

    /**
     * Basic HTTP GET request on a given URL with parameters specified
     *
     * @param url The specific API URL to be used, excluding "https://api.spotify.com/v1/"
     * @return The raw json response from the request
     */
    protected final JSONObject requestGet(String token, String url) {
        // Initialisation of http get request
//        System.out.println(BASE_URL + url);

        StringBuilder getUrl = new StringBuilder(BASE_URL + url);

        if (!this.queries.isEmpty()) {
            getUrl.append("?");
            for (RequestQuery<?> query : this.queries.values()) {
                getUrl.append(query.getPair()).append("&");
            }
            getUrl.deleteCharAt(getUrl.length() - 1);
        }
        System.out.println(getUrl);
        HttpGet httpGet = new HttpGet(getUrl.toString());
        // setting headers using the token
        httpGet.setHeader("Authorization", "Bearer " + token);
        httpGet.setHeader("Content-Type", "application/json");


        try {
            HttpResponse response = httpClient.execute(httpGet);
            System.out.println(response);
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            String s = this.processBody(entity);
            if (statusLine.getStatusCode() == 200) {
                // if good request then process body and return json
                return new JSONObject(s);
                // handle other requests, taken from docs
            } else if (statusLine.getStatusCode() == 401) {
                System.out.println("Bad or expired token. This can happen if the user revoked a token or the access token has expired. You should re-authenticate the user.");
            } else if (statusLine.getStatusCode() == 403) {
                System.out.println("Bad OAuth request (wrong consumer key, bad nonce, expired timestamp...). Unfortunately, re-authenticating the user won't help here.");
            } else if (statusLine.getStatusCode() == 429) {
                System.out.println("The app has exceeded its rate limits.");
            } else if (statusLine.getStatusCode() == 400) {
                System.out.println("Bad request.");
            } else if (statusLine.getStatusCode() == 404) {
                System.out.println("Unknown request");
            } else {
                System.out.printf("Unknown fail cause, status code: %s.%n", statusLine.getStatusCode());
            }
            System.out.println(s);
            return null;


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private String processBody(HttpEntity entity) throws IOException {
        // reads in body of the request converting it to string
        if (entity != null) {
            try (InputStream inputStream = entity.getContent()) {
                Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
                String result = scanner.hasNext() ? scanner.next() : null;
                return result;
            }
        } else
            return null;
    }


    /**
     * Adds a query key value to given request proved it is allowed.
     *
     * @param query The {@code RequestQuery} to be added as the uri parameter
     */
    public void addQuery(RequestQuery<?> query) {
        if (this.restrictedQueryTypes.containsKey(query.getKey())
                && this.restrictedQueryTypes.get(query.getKey()).equals(query.getQueryType())) {
            this.queries.put(query.getKey(), query);
        }
    }


    protected <E extends Serializable> E serializeHelper(Class<E> cls, JSONObject json) {
        try {
            List<? super Serializable> parameters = new ArrayList<>();
            List<Class<? extends Serializable>> classes = new ArrayList<>();

            for (Field field : cls.getDeclaredFields()) {
                SpotifyField spotifyField = field.getAnnotation(SpotifyField.class);
                if (spotifyField == null) continue;

                Class<? extends Serializable> type = (Class<? extends Serializable>) spotifyField.type();
                String name = spotifyField.value();
                JSONObject jsonPath = json;
                if (spotifyField.path().length != 0) {
                    for (String p : spotifyField.path()) {
                        jsonPath = jsonPath.getJSONObject(p);
                    }
                }

                if (!spotifyField.required() && jsonPath.isNull(name))
                    continue;
                else if (jsonPath.isNull(name))
                    throw new SpotifySerializationException(String.format("No mapping found for spotify required field: %s. " +
                            "Java variable: %s", spotifyField.value(), field.getName()));

                classes.add(type);
                if (type.equals(String.class)) {
                    parameters.add(jsonPath.getString(name));
                } else if (type.equals(Integer.class)) {
                    parameters.add(jsonPath.getInt(name));
                } else if (type.equals(Boolean.class)) {
                    parameters.add(jsonPath.getBoolean(name));
                } else if (type.equals(Double.class)) {
                    parameters.add(jsonPath.getDouble(name));
                } else {
                    SpotifyObject spotifyObject = type.getAnnotation(SpotifyObject.class);
                    if (spotifyObject == null) continue;
                    if (spotifyField.isArray()) {

                        Class<? extends Serializable> arrayType = (Class<? extends Serializable>) Array.newInstance(type, 0).getClass();

                        JSONArray jsonArray = jsonPath.getJSONArray(name);
                        parameters.add(this.createArray(type, jsonArray));
                        // updates the last index with the correct type if its an array
                        classes.set(classes.size() - 1, arrayType);
                    } else {
                        parameters.add(this.serializeHelper(type, jsonPath.getJSONObject(name)));
                    }
                }
            }
            Constructor<?> ctor = cls.getConstructor(this.fromListToClassArray(classes));
            return (E) ctor.newInstance(parameters.toArray());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | SpotifySerializationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private <F extends Serializable> F[] createArray(Class<F> cls, JSONArray jsonArray) {
        F[] array = (F[]) Array.newInstance(cls, jsonArray.length());
        for (int i = 0; i < array.length; i++) {
            array[i] = this.serializeHelper(cls, jsonArray.getJSONObject(i));
        }
        return array;
    }

    private Class[] fromListToClassArray(List<Class<? extends Serializable>> list) {
        Class[] classes = new Class[list.size()];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = list.get(i);
        }
        return classes;
    }


    @Override
    public T serialize(JSONObject json) {
        return null;
    }
}
