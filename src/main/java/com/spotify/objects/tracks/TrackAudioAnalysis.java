package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.tracks.analysis.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class TrackAudioAnalysis implements SpotifyObject {


    @SpotifyField
    private AudioMeta meta;

    @SpotifyField
    private AudioTrack track;

    @SpotifyField
    private AudioBar[] bars;

    @SpotifyField
    private AudioBeat[] beats;

    @SpotifyField
    private AudioSection[] sections;

    @SpotifyField
    private AudioSegment[] segments;

    @SpotifyField
    private AudioTatum[] tatums;

}
