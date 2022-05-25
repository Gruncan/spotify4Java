package com.spotify.requests.artists;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public class ArtistAlbumsGet extends AbstractRequest {

    //https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-albums


    private final static String URL = "artists/{id}/albums";

    private final String id;

    public ArtistAlbumsGet(String token, String id) {
        super(token, "include_groups", "limit", "market", "offset");
        this.id = id;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{id}", this.id));
    }
}
