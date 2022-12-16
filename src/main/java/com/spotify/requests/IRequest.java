package com.spotify.requests;



public interface IRequest {

    /**
     * Executes the request to spotify
     *
     * @return {@code JSONObject} the raw json response
     */
    RequestResponse execute(String token);

}
