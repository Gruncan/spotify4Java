package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SpotifyFollowers implements SpotifyObject {

    @SpotifyOptional
    @SpotifyField
    private String href;

    @SpotifyField
    private int total;

}
