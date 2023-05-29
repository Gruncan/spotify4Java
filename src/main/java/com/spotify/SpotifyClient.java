package com.spotify;

import com.spotify.requests.SpotifyRequestVariant;

public interface SpotifyClient {


    SpotifyResponse executeRequest(SpotifyRequestVariant request);


}
