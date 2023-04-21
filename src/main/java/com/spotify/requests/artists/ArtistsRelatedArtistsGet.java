package com.spotify.requests.artists;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.artists.Artist;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;

@SpotifyRequest(value = "artists", end = "related-artist")
@SpotifySerialize(Artist.class)
public class ArtistsRelatedArtistsGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    public ArtistsRelatedArtistsGet(String id) {
        this.id = id;
    }
}
