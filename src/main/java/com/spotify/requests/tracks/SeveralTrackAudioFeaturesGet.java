package com.spotify.requests.tracks;

import com.spotify.json.JSONObject;
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
     * @param tracks The array of tracks to query
     */
    public SeveralTrackAudioFeaturesGet(String... tracks) {
        super(new ParameterPair("ids", String.class));
        super.addQuery(new RequestQuery<>("ids", Util.join(tracks, ",")));
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
