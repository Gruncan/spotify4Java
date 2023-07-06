package dev.gruncan.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import dev.gruncan.spotify.SpotifyClientBuilder;
import dev.gruncan.spotify.util.Util;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Responsible for handling Spotify authentication and return calls <br>
 * Following Spotify's Authorization Code flow
 * @see SpotifyClientBuilder
 *
 * @author Gruncan
 * @since 1.0.0
 */
//<img src="https://developer.spotify.com/images/documentation/web-api/auth-code-flow.png" width="100" height="auto">
public class SpotifyHttpServerProvider {


    protected final SpotifyClientBuilder spotifyClientBuilder;
    private HttpServer server;
    private CountDownLatch countDownLatch;

    /**
     * Initialized the users authentication server
     * @param spotifyClientBuilder the spotifyClient requesting authentifying
     */
    public SpotifyHttpServerProvider(SpotifyClientBuilder spotifyClientBuilder) {
        this.spotifyClientBuilder = spotifyClientBuilder;
    }

    /**
     * Runs the server to receive the response from spotify given specified information from {@code SpotifyClientBuilder}
     */
    public void runServer() {
        try {
            URL url = this.spotifyClientBuilder.getRedirectUrl();

            if (!url.getHost().equals("127.0.0.1"))
                url = new URL("https://127.0.0.1:8888/redirect/");

            Desktop desktop = Desktop.getDesktop();
            this.server = HttpServer.create(new InetSocketAddress(url.getPort()), 0);
            this.countDownLatch = new CountDownLatch(1);
            this.server.createContext(url.getPath(), new RedirectHandler());

            desktop.browse(new URI(this.spotifyClientBuilder.buildAuthUrl()));
            this.server.start();
        } catch (IOException | URISyntaxException e) {
            System.out.println("Unable to start server.");
            e.printStackTrace();
        }
    }

    /**
     * Returns the {@code CountDownLatch} for ensuring required information is received before returning the built SpotifyClient
     * @see SpotifyClientBuilder#getBuiltClient()
     * @return {@code CountDownLatch} for specified server instance
     */
    public CountDownLatch getCountDownLatch() {
        return this.countDownLatch;
    }

    /**
     * Handles response from spotify and building the {@link dev.gruncan.spotify.SpotifyClient} for given {@code SpotifyClientBuilder}
     */
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
