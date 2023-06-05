package com.spotify.requests.users;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "users", end = "playlists", authorizations = {Scope.PLAYLIST_READ_PRIVATE, Scope.PLAYLIST_READ_COLLABORATIVE})
public class UserPlaylistGet implements SpotifyRequestVariant {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

    public UserPlaylistGet(String id) {
        this.id = id;
    }

}
