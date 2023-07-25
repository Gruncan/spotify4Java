package dev.gruncan.spotify.webapi.requests.me.player;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.player.SpotifyDeviceArray;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.util.Scope;

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
