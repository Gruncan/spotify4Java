package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.ParameterPair;
import com.spotify.util.Util;


/**
 * Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/check-users-saved-albums">Spotify Docs</a>
 */
public class AlbumsCheckSavedGet extends AbstractRequest {


    private final static String URL = "me/albums/contains/";

    /**
     * @param albums The array of albums to be checked
     */
    public AlbumsCheckSavedGet(String... albums) {
        super(new ParameterPair("ids", String.class));
        super.addQuery(new RequestQuery<>("ids", Util.join(albums, ",")));
    }

    @Override
    public JsonObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
