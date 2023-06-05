package com.spotify.requests.me;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/following", authorizations = Scope.USER_FOLLOW_READ)
public class MyFollowedArtistsGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private final String type;

    @SpotifyRequestField
    private String after;

    @SpotifyRequestField
    private int limit;


    public MyFollowedArtistsGet(String type) {
        this.type = type;
    }

}
