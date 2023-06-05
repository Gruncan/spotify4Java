package com.spotify.requests.me.albums;


import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "me/albums", method = HttpMethod.PUT, authorizations = Scope.USER_LIBRARY_MODIFY)
public class MyAlbumsPut implements SpotifyRequestVariant {


    @SpotifyRequestContent("ids")
    private final String[] bodyIds;
    @SpotifyRequestField
    private String[] ids;

    public MyAlbumsPut(String... ids) {
        this.bodyIds = ids;

    }

}
