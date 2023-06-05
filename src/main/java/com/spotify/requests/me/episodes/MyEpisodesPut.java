package com.spotify.requests.me.episodes;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/episodes", authorizations = Scope.USER_LIBRARY_MODIFY, method = HttpMethod.PUT)
public class MyEpisodesPut implements SpotifyRequestVariant {

    @SpotifyRequestContent("ids")
    private final String[] bodyIds;
    @SpotifyRequestField
    private String[] ids;

    public MyEpisodesPut(String... ids) {
        this.bodyIds = ids;
    }
}
