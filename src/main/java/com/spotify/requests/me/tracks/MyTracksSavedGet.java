package com.spotify.requests.me.tracks;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;


@SpotifyRequest(value = "me/tracks/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyTracksSavedGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private final String[] ids;


    public MyTracksSavedGet(String... ids) {
        this.ids = ids;
    }

}
