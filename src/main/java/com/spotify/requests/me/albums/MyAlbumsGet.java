package com.spotify.requests.me.albums;

import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/albums", authorizations = Scope.USER_LIBRARY_READ)
public class MyAlbumsGet implements SpotifyRequestVariant {

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

    @SpotifyRequestField
    private Country market;

}
