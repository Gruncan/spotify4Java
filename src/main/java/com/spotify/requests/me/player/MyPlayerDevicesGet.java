package com.spotify.requests.me.player;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.player.SpotifyDeviceArray;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

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
