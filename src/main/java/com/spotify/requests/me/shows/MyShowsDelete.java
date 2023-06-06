package com.spotify.requests.me.shows;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

/**
 * Delete one or more shows from current Spotify user's library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/remove-shows-user">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/shows", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.DELETE)
public class MyShowsDelete implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs for the shows.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     * If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.
     */
    @SpotifyRequestField
    private Country market;


    /**
     * Initializes the {@link MyShowsDelete} request
     * @param ids The Spotify IDs of the show.
     */
    public MyShowsDelete(String... ids) {
        this.ids = ids;
    }

}
