package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public class AlbumTracksGet extends AbstractRequest {

    //   https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-albums-tracks

    private final static String URL = "albums/{id}/tracks";
    private final String id;


    public AlbumTracksGet(String token, String id) {
        super(token);
        this.id = id;
        super.addRestrictionQueryType("limit", "market", "offset");
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{id}", this.id));
    }
}
