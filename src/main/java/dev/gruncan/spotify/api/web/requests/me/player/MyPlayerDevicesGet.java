package dev.gruncan.spotify.api.web.requests.me.player;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.player.SpotifyDeviceArray;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;

/**
 * Get information about a user's available devices.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-users-available-devices">Spotify Docs</a>
 * <p>Serializes into {@link SpotifyDeviceArray}</p>
 *
 * @see SpotifyDeviceArray
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/player/devices", authorizations = Scope.USER_READ_PLAYBACK_STATE)
@SpotifySerialize(SpotifyDeviceArray.class)
public class MyPlayerDevicesGet implements SpotifyRequestVariant {


}
