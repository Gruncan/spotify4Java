package com.spotify.requests.users;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import lombok.Setter;

/**
 * Get a list of the playlists owned or followed by a Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-list-users-playlists">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "users", end = "playlists", authorizations = {Scope.PLAYLIST_READ_PRIVATE, Scope.PLAYLIST_READ_COLLABORATIVE})
public class UserPlaylistGet implements SpotifyRequestVariant {

    /**
     * The user's Spotify user ID.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * The maximum number of items to return.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first playlist to return.
     */
    @SpotifyRequestField
    private int offset;

    /**
     * Initializes the {@link UserPlaylistGet} request
     * @param id The Spotify ID of the playlist.
     */
    public UserPlaylistGet(String id) {
        this.id = id;
    }

}
