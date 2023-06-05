package com.spotify.requests.me.episodes;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

/**
 * Remove one or more albums from the current user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/remove-episodes-user">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/audiobooks", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.DELETE)
public class MyEpisodesDelete implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs
     */
    @SpotifyRequestField
    private String[] ids;

    /**
     * A maximum of 50 items can be specified in one request.
     * Note: if the ids parameter is present in the query string, any IDs listed here in the body will be ignored.
     */
    @SpotifyRequestContent("ids")
    private final String[] bodyIds;

    public MyEpisodesDelete(String... ids) {
        this.bodyIds = ids;
    }
}
