package dev.gruncan.spotify.api.web.requests.me.player;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

@Deprecated
@Setter
@SpotifyRequest(value = "me/player/next", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.POST)
public class MyPlayerNextPost implements SpotifyRequestVariant {


    @SpotifyRequestField("device_id")
    private String id;

}
