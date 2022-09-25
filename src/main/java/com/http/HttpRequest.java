package com.http;

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

public class HttpRequest {

    private final String URL;
    private final HttpMethod TYPE;
    private final Map<String, String> headers;
    private final Map<String, String> query;
    private String content;


    public HttpRequest(String url, HttpMethod method) {
        this.URL = url;
        this.TYPE = method;
        this.headers = new HashMap<>();
        this.query = new HashMap<>();
        this.content = null;
    }


    public void addRequestHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public void addRequestQuery(String key, String value) {
        this.query.put(key, value);
    }

    public void addRequestQueries(Map<String, String> map) {
        this.query.putAll(map);
    }

    public void addContent(String content) {
        if (this.TYPE == HttpMethod.POST)
            this.content = content;
    }


    public HttpResponse execute() {

        try {
            String params = Util.mapToQuery(this.query);

            URL url = new URL(this.URL + params);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(this.TYPE.name());

            for (Map.Entry<String, String> pair : this.headers.entrySet()) {
                String key = pair.getKey();
                String value = pair.getValue();
                con.setRequestProperty(key, value);
            }


            if (TYPE == HttpMethod.POST && this.content != null) {
                con.setDoOutput(true);

                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = this.content.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
            }


            int code = con.getResponseCode();
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


}
