package com.spotify.requests.artists;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.AlbumTracks;
import com.spotify.objects.artists.ArtistAlbums;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "artists", end = "albums")
@SpotifySerialize(ArtistAlbums.class)
public class ArtistsAlbumsGet extends AbstractRequest {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField("include_groups")
    private String[] includeGroups;

    public ArtistsAlbumsGet(String id) {
        this.id = id;
    }

}
