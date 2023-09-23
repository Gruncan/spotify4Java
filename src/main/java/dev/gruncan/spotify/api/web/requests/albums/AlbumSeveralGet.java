package dev.gruncan.spotify.api.web.requests.albums;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.albums.Album;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import lombok.Setter;

/**
 * Get Spotify catalog information for multiple albums identified by their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-albums">Spotify Docs</a>
 * <p>Serializes into {@link Album} array</p>
 *
 * @see Album
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("albums")
@SpotifySerialize(value = Album.class, isArray = true)
public class AlbumSeveralGet implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;


    /**
     * Initializes the {@link AlbumSeveralGet} request
     * @param ids A list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    public AlbumSeveralGet(String... ids) {
        this.ids = ids;
    }

}
