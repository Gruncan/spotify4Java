package com.spotify.objects.user;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SpotifyOptional
public class Profile implements SpotifyObject {

    @SpotifyField
    private String country;

    @SpotifyField("display_name")
    private String displayName;

    @SpotifyField
    private String email;


}
