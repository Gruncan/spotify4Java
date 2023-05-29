package com.spotify.requests.connection;

import com.spotify.SpotifyClient;
import com.spotify.requests.SpotifyClientTester;

public abstract class AbstractConnectionTest {


    protected SpotifyClient client;

    public AbstractConnectionTest() {
        this.client = (SpotifyClient) SpotifyClientTester.getSpotifyClient();
    }


}
