package com.spotify.requests;

import com.http.HttpMethod;
import com.http.HttpRequest;
import com.http.HttpResponse;
import com.json.JSONException;
import com.json.JSONObject;
import com.spotify.SpotifyAPIVersion;
import com.spotify.SpotifyResponse;
import com.spotify.exceptions.SpotifyUrlParserException;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifySerialize;
import com.spotify.util.Util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Responsible for the logic of executing spotify API requests
 */
public abstract class SpotifyRequestExecutor {


    private final static String API_URL = "https://api.spotify.com";

    private String BASE_URL;

    public SpotifyRequestExecutor() {
        this.setAPIVersion(SpotifyAPIVersion.V1);
    }

    private static boolean isPrimitiveDefault(Object o, Class<?> cls) {
        if (!cls.isPrimitive()) return false;

        if (cls.equals(int.class)) {
            Integer i = (Integer) o;
            return i == 0;
        } else if (cls.equals(boolean.class)) {
            Boolean b = (Boolean) o;
            return !b;
        } else if (cls.equals(double.class)) {
            Double d = (Double) o;
            return d == 0d;
        }
        return false;
    }

    public void setAPIVersion(SpotifyAPIVersion version) {
        this.BASE_URL = String.format(API_URL + "/%s/", version);
    }

    /**
     * Basic Spotify HTTP GET request on a given URL with parameters specified
     *
     * @param token The token from spotify's authentication to be added to "Bearer" header information
     * @param url   The specific API URL to be used, excluding "https://api.spotify.com/v1/"
     * @return The HTTP response from the request, wrapped in {@link RequestResponse}
     */
    protected final RequestResponse requestGet(String token, String url) {
        // Initialisation of http get request
        String requestURL = BASE_URL + url;
        HttpMethod method = HttpMethod.GET;
        HttpRequest request = new HttpRequest(requestURL, method);
        request.addRequestHeader("Authorization", "Bearer " + token);
        request.addRequestHeader("Content-Type", "application/json");


        try {
            HttpResponse response = request.execute();
            int code = response.getCode();
            String s = response.getMessage();
            JSONObject content = null;
            switch (code) {
                case 200 -> {
                    try {
                        content = new JSONObject(response.getContent());
                    } catch (JSONException e) {
                        content = new JSONObject(String.format("{\"value\": %s}", response.getContent()));
                    }
                }
                case 401 -> System.out.printf("Error: Bad or expired token. This can happen if the user revoked a " +
                                "token or the access token has expired. You should re-authenticate the user for %s request %s%n",
                        method, requestURL);
                case 403 ->
                        System.out.printf("Error: Bad OAuth request (wrong consumer key, bad nonce, expired timestamp...)" +
                                        ". Unfortunately, re-authenticating the user won't help here for %s request %s.%n", method,
                                requestURL);
                case 429 -> System.out.println("Error: The app has exceeded its rate limits.");
                case 400 -> System.out.printf("Error: Bad request for %s request %s%n", method, requestURL);
                case 404 -> System.out.printf("Error: Unknown request for %s request %s%n", method, requestURL);
                default -> System.out.printf("Error: Unknown fail cause, status code: '%s' for %s request %s .%n", code,
                        method, requestURL);
            }

            return new RequestResponse(content, code, s);

        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Executes the subclasses request
     *
     * @param token The token from spotify's authentication
     * @return The response wrapped to be serialized {@link SpotifyResponse}
     */
    protected SpotifyResponse execute(String token, SpotifyRequestVariant request) {
        String urlQuery;
        Class<? extends SpotifyRequestVariant> requestClass = request.getClass();
        try {
            urlQuery = this.buildRequestUrl(request);
        } catch (SpotifyUrlParserException e) {
            e.printStackTrace();
            return null;
        }
        // if buildRequestUrl returns null not error
        if (urlQuery == null) return null;

        // To be changed for specified request not just GET
        RequestResponse rresponse = this.requestGet(token, urlQuery);
        SpotifySerialize ms = requestClass.getAnnotation(SpotifySerialize.class);
        if (ms == null) return null;
        // Ensured to be non-null in above buildRequestUrl call
        SpotifyRequest srequest = requestClass.getAnnotation(SpotifyRequest.class);
        Class<? extends SpotifyObject> cls = ms.value();
        SpotifyResponse response;
        if (ms.isArray())
            response = new SpotifyResponse(rresponse, cls, srequest.value().replace("-", "_"));
        else
            response = new SpotifyResponse(rresponse, cls);


        return response;
    }


    protected String buildRequestUrl(SpotifyRequestVariant request) throws SpotifyUrlParserException {
        String url = null;
        try {
            Class<? extends SpotifyRequestVariant> requestClass = request.getClass();
            SpotifyRequest spotifyRequest = requestClass.getAnnotation(SpotifyRequest.class);

            if (spotifyRequest == null) {
                throw new SpotifyUrlParserException(String.format("Class %s is not annotated with %s, unable to build " +
                        "url for unknown request.", requestClass, SpotifyRequest.class));
            }

            url = spotifyRequest.value();
            StringBuilder sb = new StringBuilder(url);
            if (!url.endsWith("/")) sb.append("/");

            List<Field> spotifySubRequestFields = new ArrayList<>();
            List<Field> spotifyFieldRequestFields = new ArrayList<>();
            for (Field field : requestClass.getDeclaredFields()) {
                if (field.getAnnotation(SpotifySubRequest.class) != null) {
                    spotifySubRequestFields.add(field);
                } else if (field.getAnnotation(SpotifyRequestField.class) != null) {
                    spotifyFieldRequestFields.add(field);
                }
            }

            // Fields annotated with SpotifySubRequest
            for (Field field : spotifySubRequestFields) {
                field.setAccessible(true);
                Object o = field.get(request);
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

            if (sb.toString().endsWith("/"))
                sb = new StringBuilder(sb.substring(0, sb.length() - 1));

            sb.append("?");

            // Fields annotated with SpotifyRequestField
            for (Field field : spotifyFieldRequestFields) {
                field.setAccessible(true);

                Object o = field.get(request);
                Class<?> type = field.getType();
                if (o == null || isPrimitiveDefault(o, type)) {
                    field.setAccessible(false);
                    continue;
                }

                String name = field.getName();
                // If not the field name
                SpotifyRequestField srf = field.getAnnotation(SpotifyRequestField.class);
                if (!srf.value().equals("\""))
                    name = srf.value();

                sb.append(name);
                sb.append("=");

                if (type.isArray()) {
                    int length = Array.getLength(o);
                    String[] strings = new String[length];
                    for (int i = 0; i < length; i++) {
                        Object v = Array.get(o, i);
                        String s = v.toString(); // Dynamic Dispatch
                        strings[i] = s;
                    }

                    String parameter = Util.join(strings, ",");
                    parameter = parameter.replace(" ", "%20");
                    sb.append(parameter);
                    sb.append("&");
                } else {
                    String v = o.toString().replace(" ", "%20");
                    sb.append(v);
                    sb.append("&");
                }
                field.setAccessible(false);
            }

            String urlQuery = sb.toString();
            urlQuery = urlQuery.substring(0, urlQuery.length() - 1);

            return urlQuery;


        } catch (IllegalAccessException e) {
            System.out.println("Unable to access a field in for request url: " + url);
            e.printStackTrace();
            return null;
        }

    }


}
 