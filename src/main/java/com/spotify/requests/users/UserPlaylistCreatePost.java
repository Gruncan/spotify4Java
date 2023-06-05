package com.spotify.requests.users;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "users", end = "playlists",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.POST)
public class UserPlaylistCreatePost implements SpotifyRequestVariant {


    @SpotifySubRequest
    private final String id;


    @SpotifyRequestContent
    private final String name;

    @SpotifyRequestContent("public")
    private boolean isPublic;

    @SpotifyRequestContent("collaborative")
    private boolean isCollaborative;

    @SpotifyRequestContent
    private String description;


    public UserPlaylistCreatePost(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
