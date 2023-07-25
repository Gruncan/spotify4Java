package dev.gruncan.spotify.webapi.objects.tracks.analysis;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import dev.gruncan.spotify.webapi.objects.tracks.TrackAudioAnalysis;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the data of a track
 *
 * @see TrackAudioAnalysis
 * @see SpotifyObject
 */
@Getter
@Setter
@SpotifyOptional
public class AudioTrack implements SpotifyObject {

    /**
     * The exact number of audio samples analyzed from this track. See also analysis_sample_rate.
     */
    @SpotifyField("num_samples")
    private int numSamples;

    /**
     * Length of the track in seconds.
     */
    @SpotifyField
    private double duration;

    /**
     * This field will always contain the empty string
     */
    @SpotifyField("sample_md5")
    private String sampleMd5;

    /**
     * An offset to the start of the region of the track that was analyzed.
     * (As the entire track is analyzed, this should always be 0.)
     */
    @SpotifyField("offset_seconds")
    private int offsetSeconds;

    /**
     * The length of the region of the track was analyzed, if a subset of the track was analyzed.
     * (As the entire track is analyzed, this should always be 0.)
     */
    @SpotifyField("window_seconds")
    private int windowSeconds;

    /**
     * The sample rate used to decode and analyze this track. May differ from the actual sample rate of this track available on Spotify.
     */
    @SpotifyField("analysis_sample_rate")
    private int analysisSampleRate;

    /**
     * The number of channels used for analysis. If 1, all channels are summed together to mono before analysis.
     */
    @SpotifyField("analysis_channels")
    private int analysisChannels;

    /**
     * The time, in seconds, at which the track's fade-in period ends. If the track has no fade-in, this will be 0.0.
     */
    @SpotifyField("end_of_fade_in")
    private double endOfFadeIn;

    /**
     * The time, in seconds, at which the track's fade-out period starts. If the track has no fade-out, this should match the track's length.
     */
    @SpotifyField("start_of_fade_out")
    private double startOfFadeOut;

    /**
     * The overall loudness of a track in decibels (dB). Loudness values are averaged across the entire track and are
     * useful for comparing relative loudness of tracks. Loudness is the quality of a sound that is the primary
     * psychological correlate of physical strength (amplitude). Values typically range between -60 and 0 db.
     */
    @SpotifyField
    private double loudness;

    /**
     * The overall estimated tempo of a track in beats per minute (BPM). In musical terminology, tempo is the speed or
     * pace of a given piece and derives directly from the average beat duration.
     */
    @SpotifyField
    private double tempo;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the tempo.
     */
    @SpotifyField("tempo_confidence")
    private double tempoConfidence;

    /**
     * An estimated time signature. The time signature (meter) is a notational convention to specify how many beats are
     * in each bar (or measure). The time signature ranges from 3 to 7 indicating time signatures of "3/4", to "7/4".
     */
    @SpotifyField("time_signature")
    private int timeSignature;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the time_signature.
     */
    @SpotifyField("time_signature_confidence")
    private double timeSignatureConfidence;

    /**
     * The key the track is in. Integers map to pitches using standard Pitch Class notation.
     * E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on. If no key was detected, the value is -1.
     */
    @SpotifyField
    private int key;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the key.
     */
    @SpotifyField("key_confidence")
    private double keyConfidence;

    /**
     * Mode indicates the modality (major or minor) of a track, the type of scale from which its melodic content is
     * derived. Major is represented by 1 and minor is 0.
     */
    @SpotifyField
    private int mode;

    /**
     * The confidence, from 0.0 to 1.0, of the reliability of the mode.
     */
    @SpotifyField("mode_confidence")
    private double modeConfidence;

    /**
     * An Echo Nest Musical Fingerprint (ENMFP) codestring for this track.
     */
    @SpotifyField("codestring")
    private String code;

    /**
     * A version number for the Echo Nest Musical Fingerprint format used in the codestring field.
     */
    @SpotifyField("code_version")
    private double codeVersion;

    /**
     * An EchoPrint codestring for this track.
     */
    @SpotifyField("echoprintstring")
    private String echoprint;

    /**
     * A version number for the EchoPrint format used in the echoprintstring field.
     */
    @SpotifyField("echoprint_version")
    private double echoPrintVersion;

    /**
     * A Synchstring for this track.
     */
    @SpotifyField("synchstring")
    private String synch;

    /**
     * A version number for the Synchstring used in the synchstring field.
     */
    @SpotifyField("synch_version")
    private double synchVersion;

    /**
     * A Rhythmstring for this track. The format of this string is similar to the Synchstring.
     */
    @SpotifyField("rhythmstring")
    private String rhythm;

    /**
     * A version number for the Rhythmstring used in the rhythmstring field.
     */
    @SpotifyField("rhythm_version")
    private double rhythmVersion;

}
