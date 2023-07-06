package dev.gruncan.spotify.objects.tracks.analysis;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.SpotifyOptional;
import dev.gruncan.spotify.objects.tracks.TrackAudioAnalysis;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify audio bar
 *
 * @see TrackAudioAnalysis
 * @see SpotifyObject
 */
@Getter
@Setter
@SpotifyOptional
public class AudioBar implements SpotifyObject {

    /**
     * The starting point (in seconds) of the time interval.
     */
    @SpotifyField
    private double start;

    /**
     * The duration (in seconds) of the time interval.
     */
    @SpotifyField
    private double duration;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the interval.
     */
    @SpotifyField
    private double confidence;


}
