package com.spotify.requests.albums;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;


/**
 * Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/check-users-saved-albums">Spotify Docs</a>
 */
@SpotifyRequest("me/albums/contains")
public class AlbumsCheckSavedGet extends AbstractRequest {


    @SpotifyRequestField
    private final String[] ids;

    /**
     * @param albums The array of albums to be checked
     */
    public AlbumsCheckSavedGet(String... albums) {
        this.ids = albums;

    }

}
