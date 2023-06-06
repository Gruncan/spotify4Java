package com.spotify.requests.me;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

/**
 * Check to see if the current user is following one or more artists or other Spotify users.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/check-current-user-follows">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/following/contains", authorizations = Scope.USER_FOLLOW_READ)
public class MyFollowingPersonGet implements SpotifyRequestVariant {

    /**
     * The ID type: either artist or user.
     */
    @SpotifyRequestField
    private final String type;

    /**
     * A list of the artist or the user Spotify IDs to check.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * Initializes the {@link MyFollowingPersonGet} request
     * @param type The ID type
     * @param ids The Spotify IDs of the artist or user.
     */
    public MyFollowingPersonGet(String type, String... ids) {
        this.type = type;
        this.ids = ids;
    }
}
