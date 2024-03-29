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
 * Set the repeat mode for the user's playback. Options are repeat-track, repeat-context, and off.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/set-repeat-mode-on-users-playback">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/player/repeat", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerRepeatPut implements SpotifyRequestVariant {

    /**
     * The state of the repeat either:
     * <ul>
     *     <li>track will repeat the current track.</li>
     *     <li>context will repeat the current context.</li>
     *     <li>off will turn repeat off.</li>
     * </ul>
     *
     */
    @SpotifyRequestField
    private final String state;

    /**
     * The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @SpotifyRequestField("device_id")
    private String id;

    /**
     * Initializes the {@link MyPlayerRepeatPut} request
     * @param state The state of the shuffle
     */
    public MyPlayerRepeatPut(String state) {
        this.state = state;
    }

}
