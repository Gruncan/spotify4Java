package com.spotify.requests;

import com.spotify.SpotifyClientBuilderTester;

public class SpotifyClientTester {


    private static SpotifyRequestExecutor spotifyClient = null;


    private SpotifyClientTester() {
    }

    public static SpotifyRequestExecutor getSpotifyClient() {
        if (spotifyClient == null) {
            spotifyClient = (SpotifyRequestExecutor) new SpotifyClientBuilderTester().getBuiltClient();
        }
        return spotifyClient;
    }

}
