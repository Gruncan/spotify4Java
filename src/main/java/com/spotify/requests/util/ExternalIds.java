package com.spotify.requests.util;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyNotRequired;
import com.spotify.objects.SpotifyObject;

@SpotifyNotRequired
public class ExternalIds implements SpotifyObject {

    @SpotifyField
    private String isrc;

    @SpotifyField
    private String ean;

    @SpotifyField
    private String upc;

}
