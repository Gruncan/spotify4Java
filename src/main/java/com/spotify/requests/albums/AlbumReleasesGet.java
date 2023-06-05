package com.spotify.requests.albums;

import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;

@Setter
@SpotifyRequest("browse/new-releases")
public class AlbumReleasesGet implements SpotifyRequestVariant {


    @SpotifyRequestField
    private Country country;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

}
