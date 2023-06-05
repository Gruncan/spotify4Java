package com.spotify.requests.me.episodes;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/episodes/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyEpisodesSavedGet implements SpotifyRequestVariant {

    @SpotifyRequestField
    private final String[] ids;


    public MyEpisodesSavedGet(String... ids) {
        this.ids = ids;
    }
}
