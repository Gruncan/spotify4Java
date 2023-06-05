package com.spotify.requests.me.audiobooks;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;


@SpotifyRequest(value = "me/audiobooks/contains", authorizations = Scope.USER_LIBRARY_READ)
public class MyAudiobooksSavedGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private final String[] ids;


    public MyAudiobooksSavedGet(String... ids) {
        this.ids = ids;
    }
}
