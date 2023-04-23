package com.spotify.requests.artists;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.albums.AlbumTracks;
import com.spotify.objects.artists.ArtistAlbums;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.albums.AlbumGet;
import lombok.Setter;

/**
 * Get Spotify catalog information about an artist's albums.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-artists-albums">Spotify Docs</a>
 * <p>Serializes into {@link AlbumTracks}</p>
 *
 * @see AlbumTracks
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "artists", end = "albums")
@SpotifySerialize(ArtistAlbums.class)
public class ArtistsAlbumsGet extends AbstractRequest {

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
     * @param id The Spotify ID of the album.
     */
    public ArtistsAlbumsGet(String id) {
        this.id = id;
    }

}
