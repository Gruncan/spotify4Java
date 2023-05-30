package com.http;

import com.spotify.SpotifyClientBuilder;
import com.spotify.requests.SpotifyRequestExecutor;
import com.spotify.util.Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a HTTP request, used for doing every request to spotify's API
 *
 * @author Gruncan
 * @see HttpMethod
 * @see HttpResponse
 * @see SpotifyHttpServerProvider
 * @see SpotifyRequestExecutor
 * @see SpotifyClientBuilder
 * @since 1.0.0
 */
public class HttpRequest {


    /** The URL of the request */
    private final String URL;
    /** The type of request */
    private final HttpMethod TYPE;
    /** The headers for the request */
    private final Map<String, String> headers;
    /** The query for the request */
    private final Map<String, String> query;
    /** The body for the request
     *  only for when {@code HttpMethod} is {@link HttpMethod#POST}
     */
    private String content;

    /**
     * Initializes a {@code HttpRequest}
     * @param url    the url for the request
     * @param method the type of the request
     */
    public HttpRequest(String url, HttpMethod method) {
        this.URL = url;
        this.TYPE = method;
        this.headers = new HashMap<>();
        this.query = new HashMap<>();
        this.content = null;
    }

    /**
     * Adds a key value pair to the header information
     * @param key   a key parameter
     * @param value a value associated with the key
     */
    public void addRequestHeader(String key, String value) {
        this.headers.put(key, value);
    }

    /**
     * Adds a key value pair to the parameters in the form "<block>url?key=value\&... </block>"
     * @param key   a key parameter
     * @param value a value associated with the key
     */
    public void addRequestQuery(String key, String value) {
        this.query.put(key, value);
    }

    /**
     * Adds multiple key value pairs to the map
     * @param map the map containing key value pairs to be added
     */
    public void addRequestQueries(Map<String, String> map) {
        this.query.putAll(map);
    }

    /**
     * Sets the content of the request, only for when {@code HttpMethod} is {@link HttpMethod#POST}
     * @param content the content to be set
     */
    public void addContent(String content) {
        if (this.TYPE == HttpMethod.POST)
            this.content = content;
    }

    /**
     * Executes the HTTP request for specified: {@code URL}, {@code TYPE}, {@code headers}, {@code query};
     * {@code content} if {@link HttpMethod#POST}
     * @return {@link HttpResponse}; or {@code null} if failed to connect
     */
    public HttpResponse execute() {

        try {
            String params = Util.mapToQuery(this.query);

            URL url = new URL(this.URL + params);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(this.TYPE.name());
            if (this.TYPE == HttpMethod.POST || this.TYPE == HttpMethod.PUT) {
                int length = 0;
                if (this.content != null) length = this.content.getBytes().length;

                con.setFixedLengthStreamingMode(length);
                con.setDoOutput(true);
            }

            for (Map.Entry<String, String> pair : this.headers.entrySet()) {
                String key = pair.getKey();
                String value = pair.getValue();
                con.setRequestProperty(key, value);
            }

            if ((TYPE == HttpMethod.POST || TYPE == HttpMethod.PUT) && this.content != null) {
                con.setDoOutput(true);
                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = this.content.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
            }


            int code = con.getResponseCode();
            // if request failed at receiver end
            if (code != 200)
                return new HttpResponse(code, null, con.getResponseMessage());

            // if request failed at client end
            InputStream is = con.getErrorStream();
            if (is == null)
                is = con.getInputStream();


            String content = new BufferedReader(new InputStreamReader(is))
                    .lines().collect(Collectors.joining("\n"));
            return new HttpResponse(code, content, con.getResponseMessage());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public String toString() {
        return String.format("%s %s\n\tQuery:%s\n\tHeaders: %s\n\tContent: %s", this.TYPE, this.URL,
                this.mapToString(this.query), this.mapToString(this.headers), this.content);
    }

    private String mapToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append("\n\t\t");
        }
        return sb.toString();
    }

    public String getURL() {
        return this.URL;
    }

    public HttpMethod getMethod() {
        return this.TYPE;
    }


}
