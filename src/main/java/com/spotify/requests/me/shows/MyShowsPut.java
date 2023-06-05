package com.spotify.requests.me.shows;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/shows", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.PUT)
public class MyShowsPut implements SpotifyRequestVariant {


    private final String[] ids;

    public MyShowsPut(String... ids) {
        this.ids = ids;
    }

}
