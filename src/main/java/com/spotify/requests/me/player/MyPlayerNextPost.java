package com.spotify.requests.me.player;

import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;

@Deprecated
@Setter
//@SpotifyRequest(value = "me/player/next", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.POST)
public class MyPlayerNextPost implements SpotifyRequestVariant {


    @SpotifyRequestField("device_id")
    private String id;

}
