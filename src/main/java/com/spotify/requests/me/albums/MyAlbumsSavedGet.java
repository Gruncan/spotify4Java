package com.spotify.requests.me.albums;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/albums/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyAlbumsSavedGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private final String[] ids;

    public MyAlbumsSavedGet(String... ids) {
        this.ids = ids;
    }
}
