package dev.gruncan.spotify.api.web.requests.me.player;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

/**
 * Set the volume for the user's current playback device.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/set-volume-for-users-playback">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/player/volume", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerSetVolumePut implements SpotifyRequestVariant {

    /**
     * The volume to set. Must be a value from 0 to 100 inclusive.
     */
    @SpotifyRequestField("volume_percent")
    private final int volume;

    /**
     * The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @SpotifyRequestField("device_id")
    private String id;

    /**
     * Initializes the {@link MyPlayerSetVolumePut} request
     * @param volume The volume to be set
     */
    public MyPlayerSetVolumePut(int volume) {
        this.volume = volume;
    }
}
