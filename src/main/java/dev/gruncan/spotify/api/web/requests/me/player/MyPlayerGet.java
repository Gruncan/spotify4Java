package dev.gruncan.spotify.api.web.requests.me.player;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.player.PlaybackState;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;

/**
 * Get information about the user's current playback state, including track or episode, progress, and active device.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-information-about-the-users-current-playback">Spotify Docs</a>
 * <p>Serializes into {@link PlaybackState}</p>
 *
 * @see PlaybackState
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/player", authorizations = Scope.USER_READ_PLAYBACK_STATE)
@SpotifySerialize(PlaybackState.class)
public class MyPlayerGet implements SpotifyRequestVariant {

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * A list of item types that your client supports besides the default track type. Valid types are: track and episode.
     */
    @SpotifyRequestField("additional_types")
    private String additionalTypes;

}
