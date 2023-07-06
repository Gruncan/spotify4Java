package dev.gruncan.spotify;

import dev.gruncan.spotify.requests.SpotifyRequestVariant;

public interface SpotifyClient {


    SpotifyResponse executeRequest(SpotifyRequestVariant request);


}
