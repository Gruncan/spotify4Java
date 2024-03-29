package dev.gruncan.spotify.webapi.requests.albums;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.albums.AlbumTracks;
import dev.gruncan.spotify.webapi.objects.wrappers.Country;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information about an album's tracks. Optional parameters can be used to limit the number of tracks returned.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-albums-tracks">Spotify Docs</a>
 * <p>Serializes into {@link AlbumTracks}</p>
 *
 * @see AlbumTracks
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifySerialize(AlbumTracks.class)
@SpotifyRequest(value = "albums", end = "tracks")
public class AlbumTracksGet implements SpotifyRequestVariant {


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
