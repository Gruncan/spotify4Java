package com.spotify.requests.albums;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

@Setter
@SpotifyRequest("albums")
@SpotifySerialize(value = Album.class, isArray = true)
public class SeveralAlbumsGet extends AbstractRequest {

    @SpotifyRequestField
    private final String[] ids;

    @SpotifyRequestField
    private Country market;


    public SeveralAlbumsGet(String... ids) {
        this.ids = ids;
        this.market = null;
    }

}
