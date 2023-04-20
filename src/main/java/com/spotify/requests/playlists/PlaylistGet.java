package com.spotify.requests.playlists;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest("playlists")
public class PlaylistGet extends AbstractRequest {

    @SpotifySubRequest
    private final String playlist_id;

    @SpotifyRequestField
    private Market market;

    @SpotifyRequestField
    private String[] fields;

    @SpotifyRequestField("additional_types")
    private String[] additionalTypes;

    public PlaylistGet(String id) {
        this.playlist_id = id;
    }

}
