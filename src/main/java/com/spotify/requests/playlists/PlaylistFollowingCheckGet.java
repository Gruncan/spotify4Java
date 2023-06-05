package com.spotify.requests.playlists;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;

@SpotifyRequest(value = "playlist", end = "followers/contains")
public class PlaylistFollowingCheckGet implements SpotifyRequestVariant {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private final String[] ids;


    public PlaylistFollowingCheckGet(String id, String... ids) {
        this.id = id;
        this.ids = ids;
    }

}
