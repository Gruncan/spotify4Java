package com.spotify.requests.me.shows;

import com.spotify.objects.wrappers.Country;
import com.spotify.requests.*;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "shows", end = "episodes", authorizations = Scope.USER_READ_PLAYBACK_POSITION)
public class MyShowEpisodesGet implements SpotifyRequestVariant {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestContent
    private Country market;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

    public MyShowEpisodesGet(String id) {
        this.id = id;
    }


}
