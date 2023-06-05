package com.spotify.requests.me.shows;

import com.http.HttpMethod;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/shows", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.DELETE)
public class MyShowsDelete implements SpotifyRequestVariant {

    private final String[] ids;

    private Country market;


    public MyShowsDelete(String... ids) {
        this.ids = ids;
    }

}
