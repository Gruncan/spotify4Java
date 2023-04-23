package com.spotify.requests.albums;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

/**
 * Get Spotify catalog information for multiple albums identified by their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-albums">Spotify Docs</a>
 * <p>Serializes into {@link Album}</p>
 *
 * @see Album
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 */
@Setter
@SpotifyRequest("albums")
@SpotifySerialize(value = Album.class, isArray = true)
public class SeveralAlbumsGet extends AbstractRequest {

    /**
     * A comma-separated list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;


    /**
     * Initializes the {@link SeveralAlbumsGet} request
     * @param ids A list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    public SeveralAlbumsGet(String... ids) {
        this.ids = ids;
        this.market = null;
    }

}
