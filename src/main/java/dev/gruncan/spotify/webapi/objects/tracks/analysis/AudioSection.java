package dev.gruncan.spotify.webapi.objects.tracks.analysis;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import dev.gruncan.spotify.webapi.objects.tracks.TrackAudioAnalysis;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify audio section
 *
 * @see TrackAudioAnalysis
 * @see SpotifyObject
 */
@Getter
@Setter
@SpotifyOptional
public class AudioSection implements SpotifyObject {

    /**
     * The starting point (in seconds) of the section.
     */
    @SpotifyField
    private double start;

    /**
     * The duration (in seconds) of the section.
     */
    @SpotifyField
    private double duration;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the section's "designation".
     */
    @SpotifyField
    private double confidence;

    /**
     * The overall loudness of the section in decibels (dB). Loudness values are useful for comparing relative loudness of sections within tracks.
     */
    @SpotifyField
    private double loudness;

    /**
     * The overall estimated tempo of the section in beats per minute (BPM). In musical terminology,
     * tempo is the speed or pace of a given piece and derives directly from the average beat duration
     */
    @SpotifyField
    private double tempo;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the tempo. Some tracks contain tempo changes or sounds
     * which don't contain tempo (like pure speech) which would correspond to a low value in this field.
     */
    @SpotifyField("tempo_confidence")
    private double tempConfidence;

    /**
     * The estimated overall key of the section. The values in this field ranging from 0 to 11 mapping to pitches
     * using standard Pitch Class notation (E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on). If no key was detected, the value is -1.
     */
    @SpotifyField
    private int key;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the key. Songs with many key changes may correspond to low values in this field.
     */
    @SpotifyField("key_confidence")
    private double keyConfidence;

    /**
     * Indicates the modality (major or minor) of a section, the type of scale from which its melodic content is derived.
     * This field will contain a 0 for "minor", a 1 for "major", or a -1 for no result. Note that the major key (e.g. C major)
     * could more likely be confused with the minor key at 3 semitones lower (e.g. A minor) as both keys carry the same pitches.
     */
    @SpotifyField
    private double mode;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the mode.
     */
    @SpotifyField("mode_confidence")
    private double modeConfidence;

    /**
     * An estimated time signature. The time signature (meter) is a notational convention to specify how many beats
     * are in each bar (or measure). The time signature ranges from 3 to 7 indicating time signatures of "3/4", to "7/4".
     */
    @SpotifyField("time_signature")
    private int timeSignature;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the time_signature. Sections with time signature changes
     * may correspond to low values in this field.
     */
    @SpotifyField("time_signature_confidence")
    private double timeSignatureConfidence;


}
