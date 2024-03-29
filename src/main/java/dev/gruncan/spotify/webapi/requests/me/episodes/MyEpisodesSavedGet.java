package dev.gruncan.spotify.webapi.requests.me.episodes;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.util.Scope;

/**
 * Check if one or more episodes is already saved in the current Spotify user's 'Your Episodes' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/check-users-saved-episodes">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me/episodes/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyEpisodesSavedGet implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs for the episodes. Maximum: 50 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;


    /**
     * Initializes the {@link MyEpisodesSavedGet} request
     *
     * @param ids The Spotify IDS of the episodes.
     */
    public MyEpisodesSavedGet(String... ids) {
        this.ids = ids;
    }
}
