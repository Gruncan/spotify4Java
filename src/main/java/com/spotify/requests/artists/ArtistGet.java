package com.spotify.requests.artists;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public class ArtistGet extends AbstractRequest {

    //https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artist


    private final static String URL = "artists/{id}/";
    private final String id;

    public ArtistGet(String token, String id) {
        super(token);
        this.id = id;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{id}", this.id));
    }
}
