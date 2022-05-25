package com.spotify.requests.artists;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public class ArtistRelatedArtistsGet extends AbstractRequest {

    private final static String URL = "artists/{id}/related-artists/";

    private final String id;

    public ArtistRelatedArtistsGet(String token, String id) {
        super(token);
        this.id = id;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{id}", this.id));
    }
}
