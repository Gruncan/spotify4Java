package dev.gruncan.spotify.api.web.requests.me.albums;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.albums.SavedAlbums;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;


/**
 * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-saved-albums">Spotify Docs</a>
 * <p>Serializes into {@link SavedAlbums}</p>
 *
 * @see SavedAlbums
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/albums", authorizations = Scope.USER_LIBRARY_READ)
@SpotifySerialize(SavedAlbums.class)
public class MyAlbumsGet implements SpotifyRequestVariant {

    /**
     * The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @SpotifyRequestField
    private int offset;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @SpotifyRequestField
    private Country market;

}
