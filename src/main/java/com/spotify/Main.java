package com.spotify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {


    private static final String CLIENTID = "49d248093d8c41dd8b65aba37c5ef665";
    private static final String CLIENTSECRET = "381ccdf476ac4584b0d936663d5c2232";
    private static final String REDIRECTURL = "https://github.com/Gruncan/spotstat"; //whiltelisted set inside spotify

    public static void main(String[] args) {
        try {
            String url_auth =
                    "https://accounts.spotify.com/authorize?"
                            + "client_id=" + CLIENTID + "&"
                            + "response_type=code&"
                            + "redirect_uri=" + REDIRECTURL + "&"
                            + "scope=user-read-private%20user-read-email&"
                            + "state=34fFs29kd09";

            System.out.println(url_auth);

            URL url = new URL(url_auth);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpResponse response;
//        try {
//            HttpGet httpGet = new HttpGet("https://api.spotify.com/v1/me");
//            httpGet.setHeader("Content-type", "application/json");
//            response = httpClient.execute(httpGet);
//            System.out.println(response);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }

    }


}
