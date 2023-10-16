package dev.gruncan.spotify.api.web.requests.me.tracks;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestContent;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

/**
 * Remove one or more tracks from the current user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/remove-tracks-user">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/tracks", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.DELETE)
public class MyTracksDelete implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs.
     */
    @SpotifyRequestField
    private String[] ids;

    /**
     * An array of the Spotify IDs.
     */
    @SpotifyRequestContent("ids")
    private final String[] bodyIds;

    /**
     * Initializes the {@link MyTracksDelete} request
     * @param ids The Spotify IDS of the tracks.
     */
    public MyTracksDelete(String... ids) {
        this.bodyIds = ids;
    }

}
