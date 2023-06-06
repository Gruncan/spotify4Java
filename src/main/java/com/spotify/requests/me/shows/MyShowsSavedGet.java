package com.spotify.requests.me.shows;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

/**
 * Check if one or more shows is already saved in the current Spotify user's library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/check-users-saved-shows">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/shows/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyShowsSavedGet implements SpotifyRequestVariant {


    /**
     * A list of the Spotify IDs for the shows.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * Initializes the {@link MyShowsSavedGet} request
     * @param ids The Spotify IDs of the show.
     */
    public MyShowsSavedGet(String... ids) {
        this.ids = ids;
    }
}
