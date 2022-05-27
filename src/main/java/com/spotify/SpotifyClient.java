package com.spotify;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;

public interface SpotifyClient {


    // to be changed
    JSONObject executeRequest(AbstractRequest abstractRequest);


}
