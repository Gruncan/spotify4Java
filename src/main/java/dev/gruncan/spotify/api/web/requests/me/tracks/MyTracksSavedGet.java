package dev.gruncan.spotify.api.web.requests.me.tracks;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;


/**
 * Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/check-users-saved-tracks">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/tracks/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyTracksSavedGet implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * Initializes the {@link MyTracksSavedGet} request
     * @param ids The Spotify IDs of the tracks.
     */
    public MyTracksSavedGet(String... ids) {
        this.ids = ids;
    }

}
