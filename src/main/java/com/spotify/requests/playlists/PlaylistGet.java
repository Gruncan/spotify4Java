package com.spotify.requests.playlists;

import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest("playlists")
public class PlaylistGet extends AbstractRequest {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Country market;

    @SpotifyRequestField
    private String[] fields;

    @SpotifyRequestField("additional_types")
    private String[] additionalTypes;

    public PlaylistGet(String id) {
        this.id = id;
    }

}
