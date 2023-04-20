package com.spotify.requests.artists;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@SpotifyRequest(value = "artists", end = "albums")
@Setter
public class ArtistsAlbumsGet extends AbstractRequest {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private String[] include_groups;

    public ArtistsAlbumsGet(String id) {
        this.id = id;
    }

}
