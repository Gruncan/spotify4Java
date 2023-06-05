package com.spotify.requests.me.shows;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;


@Setter
@SpotifyRequest(value = "me/shows", authorizations = Scope.USER_LIBRARY_READ)
public class MyShowsGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

}
