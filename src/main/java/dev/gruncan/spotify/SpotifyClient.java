package dev.gruncan.spotify;

import dev.gruncan.spotify.api.SpotifyRequestVariant;

public interface SpotifyClient {


    SpotifyResponse executeRequest(SpotifyRequestVariant request);


}
