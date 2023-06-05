package com.spotify.requests.me.player;

import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;

@Setter
//@SpotifyRequest(value = "me/player/previous", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.POST)
public class MyPlayerPreviousPost implements SpotifyRequestVariant {


    @SpotifyRequestField("device_id")
    private String id;

}
