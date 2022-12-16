package com.spotify.requests;

import com.http.HttpMethod;
import com.http.HttpRequest;
import com.http.HttpResponse;
import com.spotify.json.JSONObject;
import com.spotify.requests.util.ParameterPair;
import com.spotify.util.Util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The base of the API requests
 */
public abstract class AbstractRequest implements IRequest {


    private final static String BASE_URL = "https://api.spotify.com/v1/";
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

    private static <T> boolean isPrimitiveDefault(Object o, Class<T> cls) {
        if (!cls.isPrimitive()) return false;

        if (cls.equals(int.class)) {
            Integer i = (Integer) o;
            return i == -1;
        } else if (cls.equals(boolean.class)) {
            Boolean b = (Boolean) o;
            return !b;
        } else if (cls.equals(double.class)) {
            Double d = (Double) o;
            return d == -1;
        }
        return false;
    }

    private static <T> String convertToString(Class<T> cls, Object o) {
        T v = (T) o;
        return v.toString();
    }

    /**
     * Basic HTTP GET request on a given URL with parameters specified
     *
     * @param url The specific API URL to be used, excluding "https://api.spotify.com/v1/"
     * @return The raw json response from the request
     */
    protected final JSONObject requestGet(String token, String url) {
        // Initialisation of http get request


        HttpRequest request = new HttpRequest(BASE_URL + url, HttpMethod.GET);
        request.addRequestHeader("Authorization", "Bearer " + token);
        request.addRequestHeader("Content-Type", "application/json");


        try {
            HttpResponse response = request.execute();
            int code = response.getCode();
            String s = response.getMessage();
            switch (code) {
                case 200:
                    return new JSONObject(response.getContent());
                case 401:
                    System.out.println("Bad or expired token. This can happen if the user revoked a " +
                            "token or the access token has expired. You should re-authenticate the user.");
                case 403:
                    System.out.println("Bad OAuth request (wrong consumer key, bad nonce, expired timestamp...)" +
                            ". Unfortunately, re-authenticating the user won't help here.");
                case 429:
                    System.out.println("The app has exceeded its rate limits.");
                case 400:
                    System.out.println("Bad request.");
                case 404:
                    System.out.println("Unknown request");
                default:
                    System.out.printf("Unknown fail cause, status code: %s.%n", code);
            }
            System.out.println(s);

            return null;


        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject execute(String token) throws IllegalAccessException {
        SpotifyRequest spotifyRequest = this.getClass().getAnnotation(SpotifyRequest.class);

        if (spotifyRequest == null) return null; //class is not annotated, to be handled properly

        String url = spotifyRequest.value();
        StringBuilder sb = new StringBuilder(url);
        if (!url.endsWith("/")) sb.append("/");

        List<Field> spotifySubRequestFields = new ArrayList<>();
        List<Field> spotifyFieldRequestFields = new ArrayList<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.getAnnotation(SpotifySubRequest.class) != null) {
                spotifySubRequestFields.add(field);
            } else if (field.getAnnotation(SpotifyRequestField.class) != null) {
                spotifyFieldRequestFields.add(field);
            }
        }

        for (Field field : spotifySubRequestFields) {
            field.setAccessible(true);
            Object o = field.get(this);
            if (o == null) {
                field.setAccessible(false);
                continue;
            }
            sb.append(o).append("/");
            field.setAccessible(false);
        }

        String end = spotifyRequest.end();
        if (!end.equals("")) {
            sb.append(end);
        }

        for (Field field : spotifyFieldRequestFields) {
            field.setAccessible(true);
            if (!sb.toString().endsWith("&") && !sb.toString().endsWith("/")) sb.append("?");

            Object o = field.get(this);
            Class<?> type = field.getType();
            if (o == null || isPrimitiveDefault(o, type)) {
                field.setAccessible(false);
                continue;
            }

            sb.append(field.getName());
            sb.append("=");
            System.out.println(field);

            if (type.isArray()) {
                int length = Array.getLength(o);
                Class<?> componentType = type.getComponentType();
                String[] strings = new String[length];
                for (int i = 0; i < length; i++) {
                    Object v = Array.get(o, i);
                    String s = convertToString(componentType, v);
                    strings[i] = s;
                }
                sb.append("\"");
                String parameter = Util.join(strings, ",");
                sb.append(parameter).append("\"");
                sb.append("&");
            } else {
                sb.append(o);
                sb.append("&");
            }
            field.setAccessible(false);
        }

        String urlQuery = sb.toString();
//        if (!urlQuery.endsWith("/"))
            urlQuery = urlQuery.substring(0, urlQuery.length() - 1);

        System.out.println(BASE_URL + urlQuery);
        return this.requestGet(token, urlQuery);
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
}
 