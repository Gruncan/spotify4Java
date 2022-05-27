package com.webapp.controller;

import com.github.openjson.JSONObject;
import com.spotify.SpotifyClient;
import com.spotify.SpotifyClientBuilder;
import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.users.UserTopItemsGet;
import com.spotify.requests.util.Scope;
import com.spotify.requests.util.TimeRange;
import com.spotify.requests.util.Type;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

@org.springframework.stereotype.Controller
public class Controller {


    private static final String CLIENT_ID = "49d248093d8c41dd8b65aba37c5ef665";
    private static final String CLIENT_SECRET = "381ccdf476ac4584b0d936663d5c2232";
    private static final String REDIRECT_URL = "http://127.0.0.1:8888/redirect/";

    private final SpotifyClientBuilder scb;


    public Controller() {
        this.scb = new SpotifyClientBuilder(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL).setResponseType("code").addScope(Scope.USER_READ_PRIVATE, Scope.USER_READ_EMAIL, Scope.USER_LIBRARY_READ, Scope.USER_TOP_READ);
    }

    @GetMapping("/")
    public String welcome() {
        return "TestPage";
    }

    @GetMapping(value = "/spot/")
    public void spot(HttpServletResponse httpServletResponse) {
        // after going to "/spot/" redirects to spotify login
        String url_auth = scb.buildAuthUrl();
        httpServletResponse.setHeader("Location", url_auth);
        httpServletResponse.setStatus(302);
    }

    @GetMapping("/redirect/")
    // Might just be indexed not by name?
    public String redirect(@RequestParam String code) {
        // the redirect url after the user has logged in, returning the code to be used to get access and refresh tokens
        SpotifyClient spotifyClient = scb.build(code);

        AbstractRequest request = new UserTopItemsGet(Type.ARTISTS);
        request.addQuery(new RequestQuery<>("limit", 1));
        request.addQuery(new RequestQuery<>("time_range", TimeRange.LONG_TERM));


        JsonObject jsonObject = spotifyClient.executeRequest(request);
        System.out.println(jsonObject);


        return "RedirectPage";

    }


    private void fetchAccessToken(String code) throws URISyntaxException {
        String url_token = "https://accounts.spotify.com/api/token";

        // Sets url parameters in the form  <url>?key1=value1&key2=value2
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("grant_type", "authorization_code"));
        parameters.add(new BasicNameValuePair("code", code));
        parameters.add(new BasicNameValuePair("redirect_uri", REDIRECT_URL));

        URIBuilder uriBuilder = new URIBuilder(url_token);
        uriBuilder.addParameters(parameters);


        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response;
        try {
            HttpPost httppost = new HttpPost(uriBuilder.build());
            httppost.setHeader("Content-type", "application/x-www-form-urlencoded");
            // encodes client id and client secret in header
            httppost.setHeader("Authorization", "Basic " + new String(Base64.getEncoder().encode((CLIENT_ID + ":" + CLIENT_SECRET).getBytes(StandardCharsets.UTF_8))));

            // sends http post request to get the access token
            response = httpClient.execute(httppost);


            // getting the body of the response, which contains the access & refresh token
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200) { // ok request
                if (entity != null) {
                    // reading the body
                    try (InputStream instream = entity.getContent()) {
                        Scanner scanner = new Scanner(instream).useDelimiter("\\A");
                        String result = scanner.hasNext() ? scanner.next() : "";
                        System.out.printf("Result: %s%n", result);
                        JSONObject jsonObject = new JSONObject(result);
                        String token = jsonObject.get("access_token").toString();


                        // calling abstracted request to get specific data using the token supplied


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}