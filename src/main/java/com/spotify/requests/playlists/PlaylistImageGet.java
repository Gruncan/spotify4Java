package com.spotify.requests.playlists;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;

@SpotifyRequest(value = "playlists", end = "images")
public class PlaylistImageGet extends AbstractRequest {

    @SpotifySubRequest
    private final String playlist_id;

    public PlaylistImageGet(String id) {
        this.playlist_id = id;
    }
}
