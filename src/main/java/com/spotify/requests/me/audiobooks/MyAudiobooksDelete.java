package com.spotify.requests.me.audiobooks;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/audiobooks", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.DELETE)
public class MyAudiobooksDelete implements SpotifyRequestVariant {


    @SpotifyRequestField
    private final String[] ids;


    public MyAudiobooksDelete(String... ids) {
        this.ids = ids;
    }
}
