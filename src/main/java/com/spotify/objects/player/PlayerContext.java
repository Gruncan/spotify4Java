package com.spotify.objects.player;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class PlayerContext implements SpotifyObject {


    @SpotifyField
    private String type;

    @SpotifyField
    private String href;

    @SpotifyField(value = "spotify", path = "external_urls")
    private String externalUrls;

    @SpotifyField
    private String uri;

}
