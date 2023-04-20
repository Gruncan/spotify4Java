package com.spotify.requests.albums;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

@SpotifyRequest("albums")
@SpotifySerialize(value = Album.class, isArray = true)
@Setter
public class SeveralAlbumsGet extends AbstractRequest {

    @SpotifyRequestField
    private final String[] ids;

    @SpotifyRequestField
    private Market market;


    public SeveralAlbumsGet(String... ids) {
        this.ids = ids;
        this.market = null;
    }

}
