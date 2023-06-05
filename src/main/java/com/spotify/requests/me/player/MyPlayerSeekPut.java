package com.spotify.requests.me.player;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/player/seek", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerSeekPut implements SpotifyRequestVariant {


    @SpotifyRequestField("position_ms")
    private final int position;

    @SpotifyRequestField("device_id")
    private String id;

    public MyPlayerSeekPut(int position) {
        this.position = position;
    }

}
