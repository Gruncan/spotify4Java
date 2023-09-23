package dev.gruncan.spotify.api.web.requests.me.episodes;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestContent;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

/**
 * Save one or more episodes to the current user's library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/save-episodes-user">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/episodes", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.PUT)
public class MyEpisodesPut implements SpotifyRequestVariant {

    /**
     * A comma-separated list of the Spotify IDs. Maximum: 50 IDs.
     */
    @SpotifyRequestField
    private String[] ids;

    /**
     * A maximum of 50 items can be specified in one request.
     * Note: if the ids parameter is present in the query string, any IDs listed here in the body will be ignored.
     */
    @SpotifyRequestContent("ids")
    private final String[] bodyIds;

    /**
     * Initializes the {@link MyEpisodesPut} request
     *
     * @param ids The Spotify IDS of the episodes.
     */
    public MyEpisodesPut(String... ids) {
        this.bodyIds = ids;
    }
}
