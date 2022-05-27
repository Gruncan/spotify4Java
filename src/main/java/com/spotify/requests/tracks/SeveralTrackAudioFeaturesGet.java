package com.spotify.requests.tracks;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.ParameterPair;
import com.spotify.util.Util;


/**
 * Get audio features for multiple tracks based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-audio-features">Spotify Docs</a>
 */
public class SeveralTrackAudioFeaturesGet extends AbstractRequest {

    private final static String URL = "audio-features/";

    /**
     * @param token  The token of the related spotify api session
     * @param tracks The array of tracks to query
     */
    public SeveralTrackAudioFeaturesGet(String token, String... tracks) {
        super(token, new ParameterPair("ids", String.class));
        super.addQuery(new RequestQuery<>("ids", Util.join(tracks, ",")));
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }
}
