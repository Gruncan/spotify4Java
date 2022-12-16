package com.spotify;

import com.spotify.requests.IRequest;
import com.spotify.requests.RequestResponse;

public interface SpotifyClient {


    // to be changed
    RequestResponse executeRequest(IRequest request);


}
