package com.webapp.controller;

import com.github.openjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
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

@Controller
public class WelcomeController {


    private static final String CLIENT_ID = "49d248093d8c41dd8b65aba37c5ef665";
    private static final String CLIENT_SECRET = "381ccdf476ac4584b0d936663d5c2232";
    private static final String REDIRECT_URL = "http://127.0.0.1:8888/redirect/";



    @GetMapping("/")
    public String welcome() {
        return "TestPage";
    }

    @GetMapping(value = "/spot/")
    public void spot(HttpServletResponse httpServletResponse) {
        String url_auth =
                "https://accounts.spotify.com/authorize?"
                        + "client_id=" + CLIENT_ID + "&"
                        + "response_type=code&"
                        + "redirect_uri=" + REDIRECT_URL + "&"
                        + "scope=user-read-private%20user-read-email&"
                        + "state=34fFs29kd09";
        httpServletResponse.setHeader("Location", url_auth);
        httpServletResponse.setStatus(302);
    }

    @GetMapping("/redirect/")
    public String redirect(@RequestParam String code, @RequestParam String state) throws URISyntaxException {
        System.out.println("In get redirect");
        System.out.println("code: " + code);

        fetchAccessToken(code);
        return "RedirectPage";

    }


    private void fetchAccessToken(String code) throws URISyntaxException {
        String url_token = "https://accounts.spotify.com/api/token";


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
            httppost.setHeader("Authorization", "Basic " + new String(Base64.getEncoder().encode((CLIENT_ID + ":" + CLIENT_SECRET).getBytes(StandardCharsets.UTF_8))));
//            httppost.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));

            response = httpClient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200) { // ok request
                if (entity != null) {
                    try (InputStream instream = entity.getContent()) {
                        Scanner scanner = new Scanner(instream).useDelimiter("\\A");
                        String result = scanner.hasNext() ? scanner.next() : "";
                        System.out.println(result);
                        JSONObject jsonObject = new JSONObject(result);
                        String token = jsonObject.get("access_token").toString();

                        getProfile(token);

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

    private void getProfile(String token) throws IOException {
        HttpGet get = new HttpGet("https://api.spotify.com/v1/me/");
        get.setHeader("Content-Type", "application/json");
        get.setHeader("Authorization", "Bearer " + token);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                Scanner scanner = new Scanner(instream).useDelimiter("\\A");
                String result = scanner.hasNext() ? scanner.next() : "";
                System.out.println(result);
                JSONObject jsonObject = new JSONObject(result);
                System.out.println(jsonObject.toString());


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


    @GetMapping("/redirectagain")
    public String redirectAgain() {
        System.out.println("In redirect again");
        return "RedirectPage";
    }

}