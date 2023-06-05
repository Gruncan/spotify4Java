package com.spotify.requests.me.player;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/player/pause", authorizations = Scope.USER_MODIFY_PLAYBACK_STATE, method = HttpMethod.PUT)
public class MyPlayerPausePut implements SpotifyRequestVariant {


    @SpotifyRequestField("device_id")
    private String id;

}
