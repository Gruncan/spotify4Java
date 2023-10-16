package dev.gruncan.spotify.api.ads.requests;

import dev.gruncan.spotify.api.SpotifyRequestExecutor;

public class SpotifyAdRequestExecutor extends SpotifyRequestExecutor {


    public SpotifyAdRequestExecutor() {
        super("https://api-partner.spotify.com/");
    }
}
