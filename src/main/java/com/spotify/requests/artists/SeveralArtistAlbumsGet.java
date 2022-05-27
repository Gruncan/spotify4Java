package com.spotify.requests.artists;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.ParameterPair;
import com.spotify.util.Util;


/**
 * Get Spotify catalog information for several artists based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-multiple-artists">Spotify Docs</a>
 */
public class SeveralArtistAlbumsGet extends AbstractRequest {


    private final static String URL = "artists/";


    /**
     * @param artists The array of artist's ids to get
     */
    public SeveralArtistAlbumsGet(String... artists) {
        super(new ParameterPair("ids", String.class));
        super.addQuery(new RequestQuery<>("ids", Util.join(artists, ",")));
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
