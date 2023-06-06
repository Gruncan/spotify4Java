package com.spotify.requests.playlists;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;

/**
 * Get Spotify catalog information for a single album.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-album">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "playlist", end = "followers/contains")
public class PlaylistFollowingCheckGet implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * A comma-separated list of Spotify User IDs;<br>
     * the ids of the users that you want to check to see if they follow the playlist.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * Initializes the {@link PlaylistFollowingCheckGet} request
     * @param id The id of the playlist
     * @param ids The IDs of the users to check
     */
    public PlaylistFollowingCheckGet(String id, String... ids) {
        this.id = id;
        this.ids = ids;
    }

}
