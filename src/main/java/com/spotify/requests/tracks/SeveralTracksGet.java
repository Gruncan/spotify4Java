package com.spotify.requests.tracks;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPairBuilder;
import com.spotify.util.Util;


/**
 * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-tracks">Spotify Docs</a>
 */
public class SeveralTracksGet extends AbstractRequest {


    private final static String URL = "tracks/";


    /**
     * @param tracks The array of tracks to get
     */
    public SeveralTracksGet(String... tracks) {
        super(new ParameterPairBuilder().addKeys("ids", "market").addClasses(String.class, Market.class).build());
        super.addQuery(new RequestQuery<>("ids", Util.join(tracks, ",")));

    }

    @Override
    public JsonObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
