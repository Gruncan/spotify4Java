package com.spotify.requests.tracks;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPair;


/**
 * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-tracks">Spotify Docs</a>
 */
public class TrackGet extends AbstractRequest {

    private final static String URL = "tracks/{id}/";

    private final String id;


    /**
     * @param token The token of the related spotify api session
     * @param id    The id of the track to be queried
     */
    public TrackGet(String token, String id) {
        super(token, new ParameterPair("market", Market.class));
        this.id = id;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{id}", this.id));
    }
}
