package com.spotify.requests.me.shows;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/shows/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyShowsSavedGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private final String[] ids;


    public MyShowsSavedGet(String... ids) {
        this.ids = ids;
    }
}
