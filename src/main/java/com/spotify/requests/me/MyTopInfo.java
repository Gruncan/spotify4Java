package com.spotify.requests.me;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/top", authorizations = Scope.USER_TOP_READ)
public class MyTopInfo implements SpotifyRequestVariant {

    @SpotifySubRequest
    private final String type;

    @SpotifyRequestField("time_range")
    private String timeRange;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;


    public MyTopInfo(String type) {
        this.type = type;
    }
}
