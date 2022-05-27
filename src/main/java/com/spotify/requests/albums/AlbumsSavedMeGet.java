package com.spotify.requests.albums;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPairBuilder;


/**
 * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-saved-albums">Spotify Docs</a>
 */
public class AlbumsSavedMeGet extends AbstractRequest {

    private final static String URL = "me/albums/";


    public AlbumsSavedMeGet() {
        super(new ParameterPairBuilder().addKeys("limit", "market", "offset")
                .addClasses(Integer.class, Market.class, Integer.class).build());
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
