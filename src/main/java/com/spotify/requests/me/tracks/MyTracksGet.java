package com.spotify.requests.me.tracks;

import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/tracks", authorizations = Scope.USER_LIBRARY_READ)
public class MyTracksGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private Country market;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;


}
