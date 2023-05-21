package com.spotify.objects.categories;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category implements SpotifyObject {


    @SpotifyField
    private String href;

    @SpotifyField
    private SpotifyImage[] icons;

    @SpotifyField
    private String id;

    @SpotifyField
    private String name;


}
