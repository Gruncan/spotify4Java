package com.spotify.requests.me;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;


/**
 * Get the current user's followed artists.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-followed">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/following", authorizations = Scope.USER_FOLLOW_READ)
public class MyFollowedArtistsGet implements SpotifyRequestVariant {

    /**
     * The ID type: currently only artist is supported.
     */
    @SpotifyRequestField
    private final String type;

    /**
     * The last artist ID retrieved from the previous request.
     */
    @SpotifyRequestField
    private String after;

    /**
     * The maximum number of items to return.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * Initializes the {@link MyFollowedArtistsGet} request<br>
     * Currently only artist is supported
     */
    public MyFollowedArtistsGet() {
        this.type = "artist";
    }

}
