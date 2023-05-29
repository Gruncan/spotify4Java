package com.spotify.objects.user;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.wrappers.Country;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SpotifyOptional
public class Profile implements SpotifyObject {

    @SpotifyField
    private Country country;

    @SpotifyField("display_name")
    private String displayName;

    @SpotifyField
    private String email;


}
