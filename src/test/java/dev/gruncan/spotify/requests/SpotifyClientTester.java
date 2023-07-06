package dev.gruncan.spotify.requests;

import dev.gruncan.spotify.SpotifyClientBuilderTester;

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
