package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotifyImage implements SpotifyObject {


    @SpotifyField
    private String url;

    @SpotifyField
    private Integer height;

    @SpotifyField
    private Integer width;


}
