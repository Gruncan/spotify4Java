package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.util.Util;

public class AlbumsCheckSavedGet extends AbstractRequest {

    // https://developer.spotify.com/documentation/web-api/reference/#/operations/check-users-saved-albums

    private final static String URL = "me/albums/contains/";


    public AlbumsCheckSavedGet(String token, String... albums) {
        super(token);
        super.addQuery(new RequestQuery<>("ids", Util.join(albums, ",")));
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }
}
