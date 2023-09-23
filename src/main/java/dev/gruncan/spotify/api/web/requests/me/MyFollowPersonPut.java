package dev.gruncan.spotify.api.web.requests.me;

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
 * Get the current user's followed artists.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/follow-artists-users">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/following", authorizations = Scope.USER_FOLLOW_MODIFY, method = HttpMethod.PUT)
public class MyFollowPersonPut implements SpotifyRequestVariant {

    /**
     * The ID type. Allowed values: "artist", "user"
     */
    @SpotifyRequestField
    private final String type;

    /**
     * A list of the artist or the user Spotify IDs.
     */
    @SpotifyRequestField
    private String[] ids;

    /**
     * An array of the artist or user Spotify IDs.
     */
    @SpotifyRequestContent("ids")
    private String[] bodyIds;


    /**
     * Initializes the {@link MyFollowPersonPut} request
     * @param type The ID type
     * @param ids The Spotify IDs of the artist or user.
     */
    public MyFollowPersonPut(String type, String... ids) {
        this.type = type;
        this.ids = ids;
        this.bodyIds = new String[]{};
    }

}
