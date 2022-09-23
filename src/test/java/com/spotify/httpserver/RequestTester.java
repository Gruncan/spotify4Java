package com.spotify.httpserver;

import com.spotify.SpotifyClient;
import com.spotify.SpotifyClientBuilder;
import com.spotify.json.JSONObject;
import com.spotify.requests.tracks.TrackGet;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class RequestTester {

    private static final String CLIENT_ID = "49d248093d8c41dd8b65aba37c5ef665";
    private static final String CLIENT_SECRET = "381ccdf476ac4584b0d936663d5c2232";
    private static final String REDIRECT_URL = "http://127.0.0.1:8888/redirect/";

    private static SpotifyClientBuilder spotifyClientBuilder;
    private static HttpServer server;


    public static void main(String[] args) throws Exception {
        Desktop desktop = Desktop.getDesktop();
        server = HttpServer.create(new InetSocketAddress(8888), 0);
        server.createContext("/redirect/", new RedirectHandler());


        spotifyClientBuilder = new SpotifyClientBuilder(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL);
        //System.out.println(spotifyClientBuilder.buildAuthUrl());
        desktop.browse(new URI(spotifyClientBuilder.buildAuthUrl()));
        server.start();

        System.out.println("Server started");


    }


    private static class RedirectHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange e) throws IOException {
            System.out.println("In handle");
            Map<String, String> requestParams = queryToMap(e.getRequestURI().getQuery());
            String code = requestParams.get("code");
            if (code == null) throw new IOException("IDEK");

            SpotifyClient spotifyClient = spotifyClientBuilder.build(code);
            //server.stop(0);

            TrackGet currentUserProfileGet = new TrackGet("2gtFMLjQpCTGekMi4oXZxN");
            JSONObject jsonObject = spotifyClient.executeRequest(currentUserProfileGet);
            System.out.println(jsonObject);


            String response = jsonObject.toString(4);
            e.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = e.getResponseBody()) {
                os.write(response.getBytes());
            } finally {
                server.stop(5);
            }


        }


        public Map<String, String> queryToMap(String query) {
            if (query == null) {
                return null;
            }
            Map<String, String> result = new HashMap<>();
            for (String param : query.split("&")) {
                String[] entry = param.split("=");
                if (entry.length > 1) {
                    result.put(entry[0], entry[1]);
                } else {
                    result.put(entry[0], "");
                }
            }
            return result;
        }

    }

}
