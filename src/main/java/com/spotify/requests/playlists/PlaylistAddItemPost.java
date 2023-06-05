package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.requests.*;
import com.spotify.requests.util.Scope;
import lombok.Setter;


@Setter
@SpotifyRequest(value = "playlists", end = "tracks",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.POST)
public class PlaylistAddItemPost implements SpotifyRequestVariant {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private String[] uris;

    @SpotifyRequestField
    private int position;


    @SpotifyRequestContent("uris")
    private String[] bodyUris;

    @SpotifyRequestContent("position")
    private int bodyPosition;


    public PlaylistAddItemPost(String id) {
        this.id = id;
    }

}
