package com.spotify;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public interface SpotifyClient {


    // to be changed
    JsonObject executeRequest(AbstractRequest abstractRequest);


}
