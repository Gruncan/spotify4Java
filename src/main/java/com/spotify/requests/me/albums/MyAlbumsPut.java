package com.spotify.requests.me.albums;


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
 * <a href="https://developer.spotify.com/documentation/web-api/reference/save-albums-user">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/albums", method = HttpMethod.PUT, authorizations = Scope.USER_LIBRARY_MODIFY)
public class MyAlbumsPut implements SpotifyRequestVariant {


    /**
     * A maximum of 50 items can be specified in one request.
     * Note: if the ids parameter is present in the query string, any IDs listed here in the body will be ignored.
     */
    @SpotifyRequestContent("ids")
    private final String[] bodyIds;
    /**
     * A list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @SpotifyRequestField
    private String[] ids;

    /**
     * Initializes the {@link MyAlbumsPut} request
     *
     * @param ids The Spotify IDS of the album.
     */
    public MyAlbumsPut(String... ids) {
        this.bodyIds = ids;

    }

}
