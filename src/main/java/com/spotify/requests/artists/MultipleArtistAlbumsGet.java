package com.spotify.requests.artists;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.util.Util;

public class MultipleArtistAlbumsGet extends AbstractRequest {

    //   https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-artists

    private final static String URL = "artists/";


    public MultipleArtistAlbumsGet(String token, String... artists) {
        super(token, "ids");
        super.addQuery(new RequestQuery<>("ids", Util.join(artists, ",")));
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }
}
