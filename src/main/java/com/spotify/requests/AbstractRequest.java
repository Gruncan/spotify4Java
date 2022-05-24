package com.spotify.requests;

import com.spotify.json.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public abstract class AbstractRequest implements IRequest {


    private final static String BASE_URL = "https://api.spotify.com/v1/";
    private final static HttpClient httpClient = HttpClientBuilder.create().build();
    protected final String token;

    public AbstractRequest(String token) {
        this.token = token;
    }


    protected final JsonObject requestGet(String url) {
        HttpGet httpGet = new HttpGet(BASE_URL + url);
        httpGet.setHeader("Authorization", "Bearer " + this.token);
        httpGet.setHeader("Content-Type", "application/json");


        try {
            HttpResponse response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String s = this.processBody(entity);
                return new JsonObject(s);
            } else if (statusLine.getStatusCode() == 401) {
                System.out.println("Bad or expired token. This can happen if the user revoked a token or the access token has expired. You should re-authenticate the user.");
            } else if (statusLine.getStatusCode() == 403) {
                System.out.println("Bad OAuth request (wrong consumer key, bad nonce, expired timestamp...). Unfortunately, re-authenticating the user won't help here.");
            } else if (statusLine.getStatusCode() == 429) {
                System.out.println("The app has exceeded its rate limits.");
            } else {
                System.out.printf("Unknown fail cause, status code: %s.%n", statusLine.getStatusCode());
            }
            return null;


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private String processBody(HttpEntity entity) throws IOException {
        if (entity != null) {
            try (InputStream inputStream = entity.getContent()) {
                Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
                String result = scanner.hasNext() ? scanner.next() : null;
                return result;
            }
        } else
            return null;
    }


}
