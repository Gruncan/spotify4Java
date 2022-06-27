package com.spotify.requests;

import com.spotify.json.JSONObject;
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
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * The base of the API requests
 */
public abstract class AbstractRequest<T extends Serializable> extends SpotifySerializer implements IRequest, Serialize<T> {


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


    @Override
    public T serialize(JSONObject json) {
        Class<T> cls = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (cls.equals(String.class))
            return (T) json.toString();
        else if (cls.equals(JSONObject.class))
            return (T) json;
        else
            return this.serializer(cls, json);
    }
}
