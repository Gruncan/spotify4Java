package com.spotify.requests.artists;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;

@SpotifyRequest(value = "artists", end = "related-artist")
public class ArtistsRelatedArtistsGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    public ArtistsRelatedArtistsGet(String id) {
        this.id = id;
    }
}
