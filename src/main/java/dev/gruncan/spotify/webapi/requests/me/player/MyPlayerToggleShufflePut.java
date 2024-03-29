package dev.gruncan.spotify.webapi.requests.me.player;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.util.Scope;
import lombok.Setter;

/**
 * Toggle shuffle on or off for user's playback.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/toggle-shuffle-for-users-playback">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/player/shuffle", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerToggleShufflePut implements SpotifyRequestVariant {

    /**
     * The state of the shuffle
     * <ul>
     * <li>true : Shuffle user's playback.</li>
     * <li>false : Do not shuffle user's playback.</li>
     * </ul>
     */
    @SpotifyRequestField(requireDefault = true)
    private final boolean state;

    /**
     * The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @SpotifyRequestField("device_id")
    private String id;

    /**
     * Initializes the {@link MyPlayerToggleShufflePut} request
     * @param state The state of the shuffle
     */
    public MyPlayerToggleShufflePut(boolean state) {
        this.state = state;
    }

}
