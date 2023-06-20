package com.spotify.requests.me.player;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
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
    @SpotifyRequestField
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
