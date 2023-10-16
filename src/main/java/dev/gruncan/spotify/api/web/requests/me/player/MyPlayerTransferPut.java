package dev.gruncan.spotify.api.web.requests.me.player;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestContent;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

/**
 * Transfer playback to a new device and determine if it should start playing.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/transfer-a-users-playback">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/player", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerTransferPut implements SpotifyRequestVariant {

    /**
     * An array containing the IDs of the device on which playback should be started/transferred.<br>
     * <i>Although an array is accepted, only a single device_id is currently supported. Supplying more than one will return 400 Bad Request</i>
     */
    @SpotifyRequestContent("device_ids")
    private final String[] ids;

    /**
     * true: ensure playback happens on new device.
     * false or not provided: keep the current playback state.
     */
    @SpotifyRequestContent
    private boolean canPlay;

    /**
     * Initializes the {@link MyPlayerTransferPut} request
     * @param id The device ID.
     */
    public MyPlayerTransferPut(String id) {
        this.ids = new String[]{id};
    }


}
