package com.spotify.requests.me.tracks;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/tracks", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.DELETE)
public class MyTracksDelete implements SpotifyRequestVariant {

    @SpotifyRequestField
    private String[] ids;

    @SpotifyRequestContent("ids")
    private String[] bodyIds;


    public MyTracksDelete(String... ids) {
        this.bodyIds = ids;
    }

}
