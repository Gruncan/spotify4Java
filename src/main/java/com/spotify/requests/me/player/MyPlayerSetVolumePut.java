package com.spotify.requests.me.player;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/player/volume", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerSetVolumePut implements SpotifyRequestVariant {

    @SpotifyRequestField("volume_percent")
    private final int volume;

    @SpotifyRequestField("device_id")
    private String id;

    public MyPlayerSetVolumePut(int volume) {
        this.volume = volume;
    }
}
