package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;


/**
 * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-saved-albums">Spotify Docs</a>
 */
public class AlbumsSavedMeGet extends AbstractRequest {

    private final static String URL = "me/albums/";

    /**
     * @param token The token of the related spotify api session
     */
    public AlbumsSavedMeGet(String token) {
        super(token, "limit", "market", "offset");
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }
}
