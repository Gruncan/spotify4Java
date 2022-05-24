package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public class AlbumGet extends AbstractRequest {


    private final static String URL = "album/{id}/";
    private final String id;


    public AlbumGet(String token, String id) {
        super(token);
        this.id = id;
    }


    @Override
    public JsonObject execute() {
        JsonObject jsonObject = super.requestGet(URL.replace("{id}", this.id));
        return jsonObject;
    }
}
