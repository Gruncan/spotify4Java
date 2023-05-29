package com.spotify.requests.playlists;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.playlists.PlaylistTracksSearch;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get full details of the items of a playlist owned by a Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-playlists-tracks">Spotify Docs</a>
 * <p>Serializes into {@link PlaylistTracksSearch}</p>
 *
 * @see PlaylistTracksSearch
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "playlists", end = "tracks")
@SpotifySerialize(PlaylistTracksSearch.class)
public class PlaylistTracksGet implements SpotifyRequestVariant {


    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * Filters for the query: a comma-separated list of the fields to return. If omitted, all fields are returned.
     */
    @SpotifyRequestField
    private String[] fields;

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
     * A list of item types that your client supports besides the default track type. Valid types are: track and episode.
     */
    @SpotifyRequestField("additional_types")
    private String[] additionalTypes;

    /**
     * Initializes the {@link PlaylistGet} request
     * @param id The Spotify ID of the playlist.
     */
    public PlaylistTracksGet(String id) {
        this.id = id;
    }


}
