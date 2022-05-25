package com.spotify.requests.artists;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public class ArtistTopTracksGet extends AbstractRequest {

    private final static String URL = "artists/{id}/top-tracks";

    private final String id;

    public ArtistTopTracksGet(String token, String id) {
        super(token, "markets");
        this.id = id;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{id}", this.id));
    }
}
