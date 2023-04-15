package com.spotify.objects.tracks.analysis;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SpotifyOptional
public class AudioSegment implements SpotifyObject {


    @SpotifyField
    private double start;

    @SpotifyField
    private double duration;

    @SpotifyField
    private double confidence;

    @SpotifyField("loudness_start")
    private double loudnessStart;

    @SpotifyField("loudness_max")
    private double loudnessMax;

    @SpotifyField("loudness_max_time")
    private double loudnessMaxTime;

    @SpotifyField("loudness_end")
    private double loudnessEnd;

    @SpotifyField
    private double[] pitches;

    @SpotifyField
    private double[] timbre;

}
