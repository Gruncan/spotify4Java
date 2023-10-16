package dev.gruncan.spotify.api.web.requests.artists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.albums.AlbumTracks;
import dev.gruncan.spotify.api.web.objects.artists.ArtistAlbums;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information about an artist's albums.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-artists-albums">Spotify Docs</a>
 * <p>Serializes into {@link AlbumTracks}</p>
 *
 * @see AlbumTracks
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "artists", end = "albums")
@SpotifySerialize(ArtistAlbums.class)
public class ArtistsAlbumsGet implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the artist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * A list of keywords that will be used to filter the response. If not supplied, all album types will be returned.
     */
    @SpotifyRequestField("include_groups")
    private String[] includeGroups;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @SpotifyRequestField
    private int offset;

    /**
     * Initializes the {@link ArtistsAlbumsGet} request
     * @param id The Spotify ID of the artist.
     */
    public ArtistsAlbumsGet(String id) {
        this.id = id;
    }

}
