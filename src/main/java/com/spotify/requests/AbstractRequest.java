package com.spotify.requests;

import com.http.HttpMethod;
import com.http.HttpRequest;
import com.http.HttpResponse;
import com.spotify.json.JSONObject;
import com.spotify.requests.util.ParameterPair;

import java.lang.reflect.Field;
import java.util.HashMap;
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

        for (RequestQuery<?> rq : this.queries.values()) {
            request.addRequestQuery(rq.getKey(), rq.getPair());
        }


        try {
            HttpResponse response = request.execute();
            int code = response.getCode();
            String s = response.getContent();
            if (code == 200) {
                return new JSONObject(s);
            } else if (code == 401) {
                System.out.println("Bad or expired token. This can happen if the user revoked a token or the access token has expired. You should re-authenticate the user.");
            } else if (code == 403) {
                System.out.println("Bad OAuth request (wrong consumer key, bad nonce, expired timestamp...). Unfortunately, re-authenticating the user won't help here.");
            } else if (code == 429) {
                System.out.println("The app has exceeded its rate limits.");
            } else if (code == 400) {
                System.out.println("Bad request.");
            } else if (code == 404) {
                System.out.println("Unknown request");
            } else {
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


        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getAnnotation(SpotifySubRequest.class) != null) {
                Object o = field.get(this);
                sb.append(o.toString()).append("/");
            } else if (field.getAnnotation(SpotifyRequestField.class) != null) {
                continue;
            }
            field.setAccessible(false);
        }

        return this.requestGet(token, BASE_URL + url);
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
