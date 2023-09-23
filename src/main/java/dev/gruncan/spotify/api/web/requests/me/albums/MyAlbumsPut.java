package dev.gruncan.spotify.api.web.requests.me.albums;


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
 * Remove one or more albums from the current user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/save-albums-user">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/albums", method = HttpMethod.PUT, authorizations = Scope.USER_LIBRARY_MODIFY)
public class MyAlbumsPut implements SpotifyRequestVariant {


    /**
     * A list of the Spotify IDs for the albums. Maximum: 20 IDs.
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
     * Initializes the {@link MyAlbumsPut} request
     *
     * @param ids The Spotify IDS of the album.
     */
    public MyAlbumsPut(String... ids) {
        this.bodyIds = ids;

    }

}
