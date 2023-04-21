package com.spotify.requests.artists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.Track;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "artists", end = "top-tracks")
@SpotifySerialize(value = Track.class, isArray = true)
public class ArtistsTopTracksGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    @SpotifyField
    private Country market;

    public ArtistsTopTracksGet(String id) {
        this.id = id;
    }

}
