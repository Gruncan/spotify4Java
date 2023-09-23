package dev.gruncan.spotify.api.web.requests.me.player;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

/**
 * Seeks to the given position in the user's currently playing track.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/seek-to-position-in-currently-playing-track">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/player/seek", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerSeekPut implements SpotifyRequestVariant {

    /**
     * The position in milliseconds to seek to. Must be a positive number.
     * Passing in a position that is greater than the length of the track will cause the player to start playing the next song.
     */
    @SpotifyRequestField(value = "position_ms", requireDefault = true)
    private final int position;

    /**
     * The id of the device this command is targeting. If not supplied, the user's currently active device is the target.
     */
    @SpotifyRequestField("device_id")
    private String id;

    /**
     * Initializes the {@link MyPlayerSeekPut} request
     * @param position The position to seek to
     */
    public MyPlayerSeekPut(int position) {
        this.position = position;
    }

}
