package com.spotify.requests.albums;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@SpotifyRequest(value = "albums", end = "tracks")
@Setter
public class AlbumTracksGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Market market;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;


    public AlbumTracksGet(String id) {
        this.id = id;
        this.market = null;
        // Defaults
        this.limit = 20;
        this.offset = 0;
    }

}
