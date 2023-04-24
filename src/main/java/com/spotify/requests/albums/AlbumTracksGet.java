package com.spotify.requests.albums;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.AlbumTracks;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information about an album’s tracks. Optional parameters can be used to limit the number of tracks returned.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-albums-tracks">Spotify Docs</a>
 * <p>Serializes into {@link AlbumTracks}</p>
 *
 * @see AlbumTracks
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifySerialize(AlbumTracks.class)
@SpotifyRequest(value = "albums", end = "tracks")
public class AlbumTracksGet extends AbstractRequest {


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
     * Initializes the {@link AlbumTracksGet} request
     * @param id The Spotify ID of the album.
     */
    public AlbumTracksGet(String id) {
        this.id = id;
    }

}
