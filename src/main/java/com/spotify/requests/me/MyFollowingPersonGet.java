package com.spotify.requests.me;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/following/contains", authorizations = Scope.USER_FOLLOW_READ)
public class MyFollowingPersonGet implements SpotifyRequestVariant {

    @SpotifyRequestField
    private final String type;

    @SpotifyRequestField
    private final String[] ids;


    public MyFollowingPersonGet(String type, String... ids) {
        this.type = type;
        this.ids = ids;
    }
}
