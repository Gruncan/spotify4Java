package dev.gruncan.spotify;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;

public interface SpotifyClient {


    SpotifyResponse executeRequest(SpotifyRequestVariant request);


}
