package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.util.Util;


public class MultipleAlbumsGet extends AbstractRequest {
    //    https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-albums


    private final static String URL = "albums/";


    public MultipleAlbumsGet(String token, String... albums) {
        super(token);
        super.addQuery(new RequestQuery<>("ids", Util.join(albums, ",")));
        super.addRestrictionQueryType("market");

    }


    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }

}
