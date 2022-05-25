package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public class AlbumGet extends AbstractRequest {
    //  https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-album

    private final static String URL = "albums/{id}/";
    private final String id;


    public AlbumGet(String token, String id) {
        super(token);
        this.id = id;
        super.addRestrictionQueryType("market");
    }


    @Override
    public JsonObject execute() {
        String updatedURL = URL.replace("{id}", this.id);

        JsonObject jsonObject = super.requestGet(updatedURL);
        return jsonObject;
    }


}
