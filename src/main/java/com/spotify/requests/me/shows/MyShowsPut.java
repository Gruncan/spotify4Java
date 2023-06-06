package com.spotify.requests.me.shows;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

/**
 * Save one or more shows to current Spotify user's library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/save-shows-user">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/shows", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.PUT)
public class MyShowsPut implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs for the shows. Maximum: 50 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * Initializes the {@link MyShowsPut} request
     * @param ids The Spotify IDS of the show
     */
    public MyShowsPut(String... ids) {
        this.ids = ids;
    }

}
