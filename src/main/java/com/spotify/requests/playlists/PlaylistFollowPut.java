package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "playlists", end = "followers",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.PUT)
public class PlaylistFollowPut implements SpotifyRequestVariant {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestContent("public")
    private boolean isPublic;


    public PlaylistFollowPut(String id) {
        this.id = id;
    }
}
