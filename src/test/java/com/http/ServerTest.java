package com.http;

import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.stream.Collectors;

public class ServerTest {

    public static void main(String[] args) throws IOException {
        // Initialised the server to test http request functionality alongside server functionality

        HttpServer server = HttpServer.create(new InetSocketAddress(8889), 0);
        server.createContext("/test/", exchange -> {
            System.out.println("In handler");
            String response = "This is the response";
            exchange.sendResponseHeaders(200, response.length());
            if (exchange.getRequestMethod().equals("POST")) {
                String content = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))
                        .lines().collect(Collectors.joining("\n"));
                System.out.println(content);
            }
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.setExecutor(null);

        server.start();

    }


}
