package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SpotifyCopyright implements SpotifyObject {


    @SpotifyOptional
    @SpotifyField
    private String text;

    @SpotifyOptional
    @SpotifyField
    private String type;

}
