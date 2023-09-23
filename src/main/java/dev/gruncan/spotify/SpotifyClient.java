package dev.gruncan.spotify;

import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;

public interface SpotifyClient {


    SpotifyResponse executeRequest(SpotifyRequestVariant request);


}
