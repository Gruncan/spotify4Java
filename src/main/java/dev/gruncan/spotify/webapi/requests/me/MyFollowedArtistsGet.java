package dev.gruncan.spotify.webapi.requests.me;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.artists.PageArtists;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.util.Scope;
import lombok.Setter;


/**
 * Get the current user's followed artists.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-followed">Spotify Docs</a>
 * <p>Serializes into {@link PageArtists}</p>
 *
 * @see PageArtists
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/following", authorizations = Scope.USER_FOLLOW_READ)
@SpotifySerialize(PageArtists.class)
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
