package com.spotify.requests.playlists;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "playlists", end = "tracks")
public class PlaylistTracksGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Market market;

    @SpotifyRequestField
    private String[] fields;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

    @SpotifyRequestField("additional_types")
    private String[] additionalTypes;

    public PlaylistTracksGet(String id) {
        this.id = id;
    }


}