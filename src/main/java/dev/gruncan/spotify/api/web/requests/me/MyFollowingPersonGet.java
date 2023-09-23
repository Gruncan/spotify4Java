package dev.gruncan.spotify.api.web.requests.me;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.wrappers.SpotifyBooleanArray;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;

/**
 * Check to see if the current user is following one or more artists or other Spotify users.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/check-current-user-follows">Spotify Docs</a>
 * <p>Serializes into {@link SpotifyBooleanArray} array</p>
 *
 * @see SpotifyBooleanArray
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/following/contains", authorizations = Scope.USER_FOLLOW_READ)
@SpotifySerialize(value = SpotifyBooleanArray.class)
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
