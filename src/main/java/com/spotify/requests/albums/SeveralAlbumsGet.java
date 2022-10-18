package com.spotify.requests.albums;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.util.Util;


/**
 * Get Spotify catalog information for multiple albums identified by their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-album">Spotify Docs</a>
 */
public class SeveralAlbumsGet extends AbstractRequest {


    private final static String URL = "albums/";

    /**
     * @param albums The array of albums to query
     */
    public SeveralAlbumsGet(String... albums) {
        super.addQuery(new RequestQuery<>("ids", Util.join(albums, ",")));

    }


    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL);
    }

}
