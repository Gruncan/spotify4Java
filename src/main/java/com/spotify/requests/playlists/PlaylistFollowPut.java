package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import lombok.Setter;


/**
 * Add the current user as a follower of a playlist.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/follow-playlist">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "playlists", end = "followers",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.PUT)
public class PlaylistFollowPut implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * Defaults to true.
     * If true the playlist will be included in user's public playlists,
     * if false it will remain private.
     */
    @SpotifyRequestContent("public")
    private boolean isPublic;

    /**
     * Initializes the {@link PlaylistFollowPut} request
     * @param id The Spotify ID of the playlist.
     */
    public PlaylistFollowPut(String id) {
        this.id = id;
    }
}
