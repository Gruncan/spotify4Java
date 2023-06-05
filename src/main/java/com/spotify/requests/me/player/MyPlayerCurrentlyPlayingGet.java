package com.spotify.requests.me.player;

import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me/player/currently-playing", authorizations = Scope.USER_READ_CURRENTLY_PLAYING)
public class MyPlayerCurrentlyPlayingGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private Country market;

    @SpotifyRequestField("additional_types")
    private String[] types;

}
