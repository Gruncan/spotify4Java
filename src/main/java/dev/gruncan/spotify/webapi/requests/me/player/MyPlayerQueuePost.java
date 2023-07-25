package dev.gruncan.spotify.webapi.requests.me.player;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import lombok.Setter;

@Deprecated
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
