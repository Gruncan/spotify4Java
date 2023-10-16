package dev.gruncan.spotify.api.web.requests;

import dev.gruncan.spotify.api.SpotifyRequestExecutor;

public class SpotifyWebRequestExecutor extends SpotifyRequestExecutor {

    public SpotifyWebRequestExecutor() {
        super("https://api.spotify.com/");
    }
}
