package com.spotify.requests.artists;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.ParameterPair;
import com.spotify.util.Util;


/**
 * Get Spotify catalog information for several artists based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-artists">Spotify Docs</a>
 */
public class SeveralArtistAlbumsGet extends AbstractRequest {

    //   https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-artists

    private final static String URL = "artists/";


    /**
     * @param token   The token of the related spotify api session
     * @param artists The array of artist's ids to get
     */
    public SeveralArtistAlbumsGet(String token, String... artists) {
        super(token, new ParameterPair("ids", String.class));
        super.addQuery(new RequestQuery<>("ids", Util.join(artists, ",")));
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }
}
