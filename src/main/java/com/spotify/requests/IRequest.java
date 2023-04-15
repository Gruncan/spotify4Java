package com.spotify.requests;


import com.spotify.SpotifyResponse;

public interface IRequest {

    /**
     * Executes the request to spotify
     *
     * @return {@code JSONObject} the raw json response
     */
    SpotifyResponse execute(String token);

}
