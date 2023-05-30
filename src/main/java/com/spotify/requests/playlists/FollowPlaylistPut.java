package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import lombok.Setter;


@Setter
@SpotifyRequest(value = "playlists", end = "followers", method = HttpMethod.PUT,
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC})
public class FollowPlaylistPut implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;


    @SpotifyRequestContent("public")
    private boolean isPublic;


    public FollowPlaylistPut(String id) {
        this.id = id;
        this.isPublic = true;
    }
}
