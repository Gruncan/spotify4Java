package com.spotify.requests;

import com.spotify.json.JsonObject;

public interface IRequest {

    /**
     * Executes the request to spotify
     *
     * @return {@code JsonObject} the raw json response
     */
    JsonObject execute(String token);

}
