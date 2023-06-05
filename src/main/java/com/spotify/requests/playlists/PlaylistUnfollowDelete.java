package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "playlists", end = "followers",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.DELETE)
public class PlaylistUnfollowDelete implements SpotifyRequestVariant {

    @SpotifySubRequest
    private final String id;


    public PlaylistUnfollowDelete(String id) {
        this.id = id;
    }

}
