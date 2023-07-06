package dev.gruncan.spotify.requests.me.player;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.requests.SpotifyRequest;
import dev.gruncan.spotify.requests.SpotifyRequestField;
import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.util.Scope;
import lombok.Setter;

@Deprecated
@Setter
@SpotifyRequest(value = "me/player/next", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.POST)
public class MyPlayerNextPost implements SpotifyRequestVariant {


    @SpotifyRequestField("device_id")
    private String id;

}
