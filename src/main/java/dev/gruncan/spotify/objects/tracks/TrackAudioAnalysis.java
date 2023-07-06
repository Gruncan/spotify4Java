package dev.gruncan.spotify.objects.tracks;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.tracks.analysis.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TrackAudioAnalysis implements SpotifyObject {


    /**
     * The audio meta data
     */
    @SpotifyField
    private AudioMeta meta;

    /**
     * The track data
     */
    @SpotifyField
    private AudioTrack track;

    /**
     * The time intervals of the bars throughout the track. A bar (or measure) is a segment of time defined as a given number of beats.
     */
    @SpotifyField
    private AudioBar[] bars;

    /**
     * The time intervals of beats throughout the track. A beat is the basic time unit of a piece of music; for example,
     * each tick of a metronome. Beats are typically multiples of tatums.
     */
    @SpotifyField
    private AudioBeat[] beats;

    /**
     * Sections are defined by large variations in rhythm or timbre, e.g. chorus, verse, bridge, guitar solo, etc.
     * Each section contains its own descriptions of tempo, key, mode, time_signature, and loudness.
     */
    @SpotifyField
    private AudioSection[] sections;

    /**
     * Each segment contains a roughly conisistent sound throughout its duration.
     */
    @SpotifyField
    private AudioSegment[] segments;

    /**
     * A tatum represents the lowest regular pulse train that a listener intuitively infers from the timing of perceived
     * musical events (segments).
     */
    @SpotifyField
    private AudioTatum[] tatums;

}
