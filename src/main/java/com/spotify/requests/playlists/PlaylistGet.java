package com.spotify.requests.playlists;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.playlists.Playlist;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get a playlist owned by a Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-playlist">Spotify Docs</a>
 * <p>Serializes into {@link Playlist}</p>
 *
 * @see Playlist
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("playlists")
public class PlaylistGet extends AbstractRequest {

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
     * Filters for the query: a list of the fields to return. If omitted, all fields are returned.
     */
    @SpotifyRequestField
    private String[] fields;

    /**
     * A list of item types that your client supports besides the default track type. Valid types are: track and episode.
     */
    @SpotifyRequestField("additional_types")
    private String[] additionalTypes;

    /**
     * Initializes the {@link PlaylistGet} request
     * @param id The Spotify ID of the playlist.
     */
    public PlaylistGet(String id) {
        this.id = id;
    }

}
