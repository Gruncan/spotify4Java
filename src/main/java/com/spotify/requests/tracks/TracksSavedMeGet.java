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


    /**
     * @param token The token of the related spotify api session
     */
    public TracksSavedMeGet(String token) {
        super(token, new ParameterPairBuilder()
                .addKeys("limit", "market", "offset").addClasses(int.class, Market.class, int.class).build());

    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }
}
