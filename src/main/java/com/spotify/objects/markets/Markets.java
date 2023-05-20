package com.spotify.objects.markets;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.wrappers.Country;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Markets implements SpotifyObject {

    @SpotifyField
    private Country[] markets;

}
