package com.spotify.requests.me.player;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

/**
 * Get the object currently being played on the user's Spotify account.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-the-users-currently-playing-track">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/player/currently-playing", authorizations = Scope.USER_READ_CURRENTLY_PLAYING)
public class MyPlayerCurrentlyPlayingGet implements SpotifyRequestVariant {

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * A comma-separated list of item types that your client supports besides the default track type. Valid types are: track and episode.
     * <i>This parameter was introduced to allow existing clients to maintain their current behaviour and might be deprecated in the future.
     * In addition to providing this parameter, make sure that your client properly handles cases of new types in the future by checking against the type field of each object.</i>
     */
    @SpotifyRequestField("additional_types")
    private String[] types;

}
