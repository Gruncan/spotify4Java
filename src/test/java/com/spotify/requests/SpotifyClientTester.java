package com.spotify.requests;

import com.spotify.SpotifyClient;
import com.spotify.SpotifyClientBuilderTester;

public class SpotifyClientTester {


    private static SpotifyClient spotifyClient = null;


    private SpotifyClientTester() {
    }

    public static SpotifyClient getSpotifyClient() {
        if (spotifyClient == null) {
            spotifyClient = new SpotifyClientBuilderTester().getBuiltClient();
        }
        return spotifyClient;
    }

}
