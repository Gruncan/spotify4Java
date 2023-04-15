package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.tracks.analysis.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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

    @Override
    public String toString() {
        return "TrackAudioAnalysis{" +
                "meta=" + meta +
                ", track=" + track +
                ", bars=" + bars.length +
                ", beats=" + beats.length +
                ", sections=" + sections.length +
                ", segments=" + segments[0] +
                ", tatums=" + tatums.length +
                '}';
    }
}
