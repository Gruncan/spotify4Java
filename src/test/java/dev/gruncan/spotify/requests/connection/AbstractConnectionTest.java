package dev.gruncan.spotify.requests.connection;

import dev.gruncan.spotify.SpotifyClient;
import dev.gruncan.spotify.requests.SpotifyClientTester;

public abstract class AbstractConnectionTest {


    protected SpotifyClient client;

    public AbstractConnectionTest() {
        this.client = (SpotifyClient) SpotifyClientTester.getSpotifyClient();
    }


}
