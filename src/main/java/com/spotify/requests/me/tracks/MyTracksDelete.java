package com.spotify.requests.me.tracks;

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
