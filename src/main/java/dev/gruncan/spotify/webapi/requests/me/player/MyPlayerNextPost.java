package dev.gruncan.spotify.webapi.requests.me.player;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.util.Scope;
import lombok.Setter;

@Deprecated
@Setter
@SpotifyRequest(value = "me/player/next", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.POST)
public class MyPlayerNextPost implements SpotifyRequestVariant {


    @SpotifyRequestField("device_id")
    private String id;

}
