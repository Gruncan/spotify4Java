package com.spotify.requests.me.player;

import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/player", authorizations = Scope.USER_READ_PLAYBACK_STATE)
public class MyPlayerGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private Country market;

    @SpotifyRequestField("additional_types")
    private String additionalTypes;

}
