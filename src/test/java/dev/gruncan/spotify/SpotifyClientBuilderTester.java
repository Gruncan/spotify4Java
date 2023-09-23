package dev.gruncan.spotify;

import dev.gruncan.spotify.api.web.requests.util.Scope;

public class SpotifyClientBuilderTester extends SpotifyClientBuilder {

    private static final String CLIENT_ID = "49d248093d8c41dd8b65aba37c5ef665";
    private static final String CLIENT_SECRET = "381ccdf476ac4584b0d936663d5c2232";
    private static final String REDIRECT_URL = "http://127.0.0.1:8888/redirect/";


    public SpotifyClientBuilderTester() {
        super(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL);
        super.addScope(Scope.values());
    }


}
