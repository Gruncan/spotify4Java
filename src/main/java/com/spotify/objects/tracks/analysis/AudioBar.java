package com.spotify.objects.tracks.analysis;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SpotifyOptional
public class AudioBar implements SpotifyObject {

    @SpotifyField
    private double start;

    @SpotifyField
    private double duration;

    @SpotifyField
    private double confidence;


}
