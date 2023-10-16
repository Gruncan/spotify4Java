package dev.gruncan.spotify.api.web.requests.albums;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.albums.Album;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single album.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-album">Spotify Docs</a>
 * <p>Serializes into {@link Album}</p>
 *
 * @see Album
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("albums")
@SpotifySerialize(Album.class)
public class AlbumGet implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the album.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;


    /**
     * Initializes the {@link AlbumGet} request
     * @param id The Spotify ID of the album.
     */
    public AlbumGet(String id) {
        this.id = id;
    }


}
