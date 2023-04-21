package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotifyImage implements SpotifyObject {


    @SpotifyField
    private String url;

    @SpotifyOptional
    @SpotifyField
    private int height;

    @SpotifyOptional
    @SpotifyField
    private int width;


}
