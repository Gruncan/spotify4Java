package dev.gruncan.spotify.requests.playlists;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.objects.SpotifySerialize;
import dev.gruncan.spotify.requests.SpotifyRequest;
import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.SpotifySubRequest;
import dev.gruncan.spotify.requests.util.Scope;

/**
 * Remove the current user as a follower of a playlist.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/unfollow-playlist">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "playlists", end = "followers",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.DELETE)
public class PlaylistUnfollowDelete implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * Initializes the {@link PlaylistUnfollowDelete} request
     * @param id The Spotify ID of the playlist.
     */
    public PlaylistUnfollowDelete(String id) {
        this.id = id;
    }

}
