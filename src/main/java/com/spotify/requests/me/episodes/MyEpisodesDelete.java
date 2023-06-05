package com.spotify.requests.me.episodes;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/audiobooks", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.DELETE)
public class MyEpisodesDelete implements SpotifyRequestVariant {

    @SpotifyRequestContent("ids")
    private final String[] bodyIds;
    @SpotifyRequestField
    private String[] ids;

    public MyEpisodesDelete(String... ids) {
        this.bodyIds = ids;
    }
}
