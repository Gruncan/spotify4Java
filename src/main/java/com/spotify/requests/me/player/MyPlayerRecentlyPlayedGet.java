package com.spotify.requests.me.player;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/player/recently-played", authorizations = Scope.USER_READ_RECENTLY_PLAYED)
public class MyPlayerRecentlyPlayedGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int after;

    @SpotifyRequestField
    private int before;

}
