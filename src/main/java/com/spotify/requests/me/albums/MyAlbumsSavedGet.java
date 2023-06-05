package com.spotify.requests.me.albums;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

/**
 * Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/check-users-saved-albums">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/albums/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyAlbumsSavedGet implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * Initializes the {@link MyAlbumsSavedGet} request
     *
     * @param ids The Spotify IDS of the album.
     */
    public MyAlbumsSavedGet(String... ids) {
        this.ids = ids;
    }
}
