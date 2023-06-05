package com.spotify.requests.me.player;

import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;

@Setter
//@SpotifyRequest(value = "me/player/queue", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.POST)
public class MyPlayerQueuePost implements SpotifyRequestVariant {


    @SpotifyRequestField
    private final String uri;

    @SpotifyRequestField("device_id")
    private String id;

    public MyPlayerQueuePost(String uri) {
        this.uri = uri;
    }

}
