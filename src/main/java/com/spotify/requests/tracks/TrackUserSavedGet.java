package com.spotify.requests.tracks;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.ParameterPair;
import com.spotify.util.Util;


/**
 * Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-album">Spotify Docs</a>
 */
public class TrackUserSavedGet extends AbstractRequest {

    private final static String URL = "me/tracks/contains/";


    /**
     * @param tracks The array of tracks to query
     */
    public TrackUserSavedGet(String... tracks) {
        super(new ParameterPair("ids", String.class));
        super.addQuery(new RequestQuery<>("ids", Util.join(tracks, ",")));
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
