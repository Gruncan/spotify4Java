package com.spotify;

import com.spotify.requests.AbstractRequest;

public interface SpotifyClient {


    // to be changed
    SpotifyResponse executeRequest(AbstractRequest request);


}
