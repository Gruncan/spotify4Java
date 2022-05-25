package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
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
     * @param token  The token of the related spotify api session
     * @param albums The array of albums to get
     */
    public SeveralAlbumsGet(String token, String... albums) {
        super(token, "market", "ids");
        super.addQuery(new RequestQuery<>("ids", Util.join(albums, ",")));

    }


    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }

}
