package com.spotify;

import com.spotify.json.JSONObject;
import com.spotify.requests.IRequest;

public interface SpotifyClient {


    // to be changed
    JSONObject executeRequest(IRequest request);


}
