package com.spotify.requests.albums;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

/**
 *
 */
@SpotifyRequest("albums")
@SpotifySerialize(Album.class)
@Setter
public class AlbumGet extends AbstractRequest {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Country market;


    public AlbumGet(String id) {
        this.id = id;
    }


}
