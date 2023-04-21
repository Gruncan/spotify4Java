package com.spotify.requests.albums;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.AlbumTracks;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifySerialize(AlbumTracks.class)
@SpotifyRequest(value = "albums", end = "tracks")
public class AlbumTracksGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Country market;

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