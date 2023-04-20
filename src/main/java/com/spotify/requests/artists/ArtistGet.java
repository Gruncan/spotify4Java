package com.spotify.requests.artists;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest("artists")
public class ArtistGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    public ArtistGet(String id) {
        this.id = id;
    }


}
