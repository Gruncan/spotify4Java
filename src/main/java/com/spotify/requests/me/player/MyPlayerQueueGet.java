package com.spotify.requests.me.player;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/player/queue", authorizations = Scope.USER_READ_PLAYBACK_STATE)
public class MyPlayerQueueGet implements SpotifyRequestVariant {

}
