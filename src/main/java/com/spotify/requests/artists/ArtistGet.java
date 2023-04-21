package com.spotify.requests.artists;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.artists.Artist;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest("artists")
@SpotifySerialize(Artist.class)
public class ArtistGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    public ArtistGet(String id) {
        this.id = id;
    }


}
