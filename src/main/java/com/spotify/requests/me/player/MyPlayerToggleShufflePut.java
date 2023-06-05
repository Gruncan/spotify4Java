package com.spotify.requests.me.player;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/player/shuffle", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerToggleShufflePut {

    @SpotifyRequestField
    private final boolean state;

    @SpotifyRequestField("device_id")
    private String id;

    public MyPlayerToggleShufflePut(boolean state) {
        this.state = state;
    }

}
