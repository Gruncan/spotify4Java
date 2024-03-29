package dev.gruncan.spotify.webapi.requests.users;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.playlists.PlaylistPage;
import dev.gruncan.spotify.webapi.objects.playlists.SimplifiedPlaylist;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.SpotifySubRequest;
import dev.gruncan.spotify.webapi.requests.util.Scope;
import lombok.Setter;

/**
 * Get a list of the playlists owned or followed by a Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-list-users-playlists">Spotify Docs</a>
 * <p>Serializes into {@link SimplifiedPlaylist}</p>
 *
 * @see SimplifiedPlaylist
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "users", end = "playlists", authorizations = {Scope.PLAYLIST_READ_PRIVATE, Scope.PLAYLIST_READ_COLLABORATIVE})
@SpotifySerialize(PlaylistPage.class)
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
     * @param id The Spotify ID of the user.
     */
    public UserPlaylistGet(String id) {
        this.id = id;
    }

}
