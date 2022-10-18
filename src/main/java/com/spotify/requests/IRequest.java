package com.spotify.requests;

import com.spotify.json.JSONObject;

public interface IRequest {

    /**
     * Executes the request to spotify
     *
     * @return {@code JSONObject} the raw json response
     */
    JSONObject execute(String token) throws IllegalAccessException;

}
