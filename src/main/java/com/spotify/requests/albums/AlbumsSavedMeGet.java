package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public class AlbumsSavedMeGet extends AbstractRequest {

    //   https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-saved-albums


    private final static String URL = "me/albums/";


    public AlbumsSavedMeGet(String token) {
        super(token, "limit", "market", "offset");
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }
}
