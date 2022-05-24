package com.webapp.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Controller
public class WelcomeController {


    private static final String CLIENT_ID = "49d248093d8c41dd8b65aba37c5ef665";
    private static final String CLIENT_SECRET = "381ccdf476ac4584b0d936663d5c2232";
    private static final String REDIRECT_URL = "http://127.0.0.1:8888/redirect/";

    private static final String REDIRECT_URL_2 = "http://127.0.0.1:8888/redirectagain/";


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
    public void redirect(@RequestParam String code, @RequestParam String state) {
        System.out.println("In get redirect");
        System.out.println("code: " + code);

        fetchAccessToken(code);


    }


    private void fetchAccessToken(String code) {
        String url_token = "https://accounts.spotify.com/api/token?"
                + "grant_type=authorization_code"
                + "&code=" + code
                + "&redirect_uri=" + REDIRECT_URL_2
                + "&client_id=" + CLIENT_ID
                + "&client_secret=" + CLIENT_SECRET;

        System.out.println(url_token);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response;
        try {
            HttpPost httppost = new HttpPost(url_token);
            httppost.setHeader("Content-type", "application/x-www-form-urlencoded");
            httppost.setHeader("Authorization", Base64.getEncoder().encodeToString(String.format("Basic %s:%s", CLIENT_ID, CLIENT_SECRET).getBytes(StandardCharsets.UTF_8)));
            response = httpClient.execute(httppost);
            System.out.println(response);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/redirectagain")
    public String redirectAgain() {
        System.out.println("In redirect again");
        return "RedirectPage";
    }

}