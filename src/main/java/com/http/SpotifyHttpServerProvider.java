package com.http;

import com.spotify.SpotifyClientBuilder;
import com.spotify.util.Util;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class SpotifyHttpServerProvider {

    protected final SpotifyClientBuilder spotifyClientBuilder;
    private HttpServer server;
    private CountDownLatch countDownLatch;

    public SpotifyHttpServerProvider(SpotifyClientBuilder spotifyClientBuilder) {
        this.spotifyClientBuilder = spotifyClientBuilder;
    }


    public void runServer() {
        try {

            Desktop desktop = Desktop.getDesktop();
            server = HttpServer.create(new InetSocketAddress(8888), 0);
            this.countDownLatch = new CountDownLatch(1);
            server.createContext("/redirect/", new RedirectHandler());

            desktop.browse(new URI(spotifyClientBuilder.buildAuthUrl()));
            server.start();
        } catch (IOException | URISyntaxException e) {
            System.out.println("Unable to start server.");
            e.printStackTrace();
        }
    }

    public CountDownLatch getCountDownLatch() {
        return this.countDownLatch;
    }

    private class RedirectHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange e) throws IOException {

            Map<String, String> requestParams = Util.queryToMap(e.getRequestURI().getQuery());
            String code = requestParams.get("code");
            if (code == null) throw new IOException("IDEK");

            spotifyClientBuilder.build(code);

            String response = "Successfully got access token, you can close this page now.";
            e.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = e.getResponseBody()) {
                os.write(response.getBytes());
            } finally {
                countDownLatch.countDown();
                server.stop(5);
            }
        }
    }


}
