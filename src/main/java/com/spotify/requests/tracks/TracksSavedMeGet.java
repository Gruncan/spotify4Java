package com.spotify.requests.tracks;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPairBuilder;


/**
 * Get a list of the songs saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/check-users-saved-tracks>Spotify Docs</a>
 */
public class TracksSavedMeGet extends AbstractRequest {

    private final static String URL = "me/tracks/";


    public TracksSavedMeGet() {
        super(new ParameterPairBuilder()
                .addKeys("limit", "market", "offset").addClasses(Integer.class, Market.class, Integer.class).build());

    }

    @Override
    public JsonObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
