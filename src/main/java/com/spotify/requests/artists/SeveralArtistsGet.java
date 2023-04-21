package com.spotify.requests.artists;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.artists.Artist;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

@Setter
@SpotifyRequest("artists")
@SpotifySerialize(value = Artist.class, isArray = true)
public class SeveralArtistsGet extends AbstractRequest {


    @SpotifyRequestField
    private final String[] ids;


    public SeveralArtistsGet(String... ids) {
        this.ids = ids;
    }

}
