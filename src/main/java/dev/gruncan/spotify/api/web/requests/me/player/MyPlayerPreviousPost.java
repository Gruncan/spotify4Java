package dev.gruncan.spotify.api.web.requests.me.player;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

@Deprecated
@Setter
@SpotifyRequest(value = "me/player/previous", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.POST)
public class MyPlayerPreviousPost implements SpotifyRequestVariant {


    @SpotifyRequestField("device_id")
    private String id;

}
