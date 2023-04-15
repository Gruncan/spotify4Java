package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotifyExternalID implements SpotifyObject {

    @SpotifyOptional
    @SpotifyField
    private String isrc;

    @SpotifyOptional
    @SpotifyField
    private String ean;

    @SpotifyOptional
    @SpotifyField
    private String upc;

}
