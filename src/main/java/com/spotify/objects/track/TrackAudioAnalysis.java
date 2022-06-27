package com.spotify.objects.track;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;

import java.util.Arrays;

public class TrackAudioAnalysis {


    private final Meta meta;
    private final Track track;
    private final Bar[] bars;
    private final Beat[] beats;
    private final Section[] sections;
    private final Segment[] segments;
    private final Tatum[] tatums;

    public TrackAudioAnalysis(Meta meta, Track track, Bar[] bars, Beat[] beats, Section[] sections, Segment[] segments, Tatum[] tatums) {
        this.meta = meta;
        this.track = track;
        this.bars = bars;
        this.beats = beats;
        this.sections = sections;
        this.segments = segments;
        this.tatums = tatums;
    }

    public Meta getMeta() {
        return meta;
    }

    public Track getTrack() {
        return track;
    }

    public Bar[] getBars() {
        return bars;
    }

    public Beat[] getBeats() {
        return beats;
    }

    public Section[] getSections() {
        return sections;
    }

    public Segment[] getSegments() {
        return segments;
    }

    public Tatum[] getTatums() {
        return tatums;
    }

    @Override
    public String toString() {
        return "TrackAudioAnalysis{" +
                "meta=" + meta +
                ", track=" + track +
                ", bars=" + Arrays.toString(bars) +
                ", beats=" + Arrays.toString(beats) +
                ", sections=" + Arrays.toString(sections) +
                ", segments=" + Arrays.toString(segments) +
                ", tatums=" + Arrays.toString(tatums) +
                '}';
    }

    /**
     * Represents the metadata of the track for the respected audio analysis
     *
     * @param analyzerVersion The version of the Analyzer used to analyze this track.
     * @param platform        The platform used to read the track's audio data.
     * @param detailedStatus  A detailed status code for this track. If analysis data is missing, this code may explain why.
     * @param statusCode      The return code of the analyzer process. 0 if successful, 1 if any errors occurred.
     * @param timestamp       The Unix timestamp (in seconds) at which this track was analyzed.
     * @param analysisTime    The amount of time taken to analyze this track.
     * @param inputProcess    The method used to read the track's audio data.
     */
    public record Meta(String analyzerVersion, String platform, String detailedStatus, int statusCode, int timestamp,
                       float analysisTime, String inputProcess) implements SpotifyObject {
        @Override
        public String toString() {
            return "Meta{" +
                    "analyzerVersion='" + analyzerVersion + '\'' +
                    ", platform='" + platform + '\'' +
                    ", detailedStatus='" + detailedStatus + '\'' +
                    ", statusCode=" + statusCode +
                    ", timestamp=" + timestamp +
                    ", analysisTime=" + analysisTime +
                    ", inputProcess='" + inputProcess + '\'' +
                    '}';
        }
    }

    /**
     * Represent a track object for the respected audio analysis
     *
     * @param numSamples              The exact number of audio samples analyzed from this track. See also analysis_sample_rate.
     * @param duration                Length of the track in seconds.
     * @param sampleMd5               This field will always contain the empty string.
     * @param offsetSeconds           An offset to the start of the region of the track that was analyzed. (As the entire track is analyzed, this should always be 0.)
     * @param windowSeconds           The length of the region of the track was analyzed, if a subset of the track was analyzed. (As the entire track is analyzed, this should always be 0.)
     * @param analysisSampleRate      The length of the region of the track was analyzed, if a subset of the track was analyzed. (As the entire track is analyzed, this should always be 0.)
     * @param analysisChannels        The sample rate used to decode and analyze this track. May differ from the actual sample rate of this track available on Spotify.
     * @param endOfFadeIn             The number of channels used for analysis. If 1, all channels are summed together to mono before analysis.
     * @param startOfFadeIn           The time, in seconds, at which the track's fade-in period ends. If the track has no fade-in, this will be 0.0.
     * @param loudness                The time, in seconds, at which the track's fade-in period ends. If the track has no fade-in, this will be 0.0.
     * @param tempo                   The time, in seconds, at which the track's fade-out period starts. If the track has no fade-out, this should match the track's length.
     * @param tempoConfidence         The overall loudness of a track in decibels (dB). Loudness values are averaged across the
     *                                entire track and are useful for comparing relative loudness of tracks. Loudness is
     *                                the quality of a sound that is the primary psychological correlate of physical strength (amplitude).
     *                                Values typically range between -60 and 0 db.
     * @param timeSignature           An estimated time signature. The time signature (meter) is a notational convention to specify
     *                                how many beats are in each bar (or measure). The time signature ranges from 3 to 7
     *                                indicating time signatures of "3/4", to "7/4".
     * @param timeSignatureConfidence The confidence, from 0.0 to 1.0, of the reliability of the time_signature.
     * @param key                     The key the track is in. Integers map to pitches using standard Pitch Class notation.
     *                                E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on. If no key was detected, the value is -1.
     * @param keyConfidence           The confidence, from 0.0 to 1.0, of the reliability of the key.
     * @param mode                    Mode indicates the modality (major or minor) of a track, the type of scale from which its melodic content is derived. Major is represented by 1 and minor is 0.
     * @param modeConfidence          The confidence, from 0.0 to 1.0, of the reliability of the mode.
     * @param codestring              An <a href="https://academiccommons.columbia.edu/doi/10.7916/D8Q248M4">Echo Nest Musical Fingerprint (ENMFP) </a> codestring for this track.
     * @param codeVersion             A version number for the Echo Nest Musical Fingerprint format used in the codestring field.
     * @param echoprintstring         An <a href="https://github.com/spotify/echoprint-codegen">EchoPrint</a> codestring for this track.
     * @param echoprintVersion        A version number for the EchoPrint format used in the echoprintstring field.
     * @param synchstring             A <a href="https://github.com/echonest/synchdata">Synchstring</a> for this track.
     * @param synchVersion            A version number for the Synchstring used in the synchstring field.
     * @param rhythmstring            A Rhythmstring for this track. The format of this string is similar to the Synchstring.
     * @param rhythmVersion           A version number for the Rhythmstring used in the rhythmstring field.
     */
    public record Track(int numSamples, float duration, String sampleMd5, int offsetSeconds, int windowSeconds,
                        int analysisSampleRate, int analysisChannels, float endOfFadeIn, float startOfFadeIn,
                        float loudness, float tempo, float tempoConfidence, int timeSignature,
                        float timeSignatureConfidence,
                        int key, float keyConfidence, int mode, float modeConfidence, String codestring,
                        float codeVersion,
                        String echoprintstring, int echoprintVersion, String synchstring, float synchVersion,
                        String rhythmstring, float rhythmVersion) implements SpotifyObject {

        @Override
        public String toString() {
            return "Track{" +
                    "numSamples=" + numSamples +
                    ", duration=" + duration +
                    ", sampleMd5='" + sampleMd5 + '\'' +
                    ", offsetSeconds=" + offsetSeconds +
                    ", windowSeconds=" + windowSeconds +
                    ", analysisSampleRate=" + analysisSampleRate +
                    ", analysisChannels=" + analysisChannels +
                    ", endOfFadeIn=" + endOfFadeIn +
                    ", startOfFadeIn=" + startOfFadeIn +
                    ", loudness=" + loudness +
                    ", tempo=" + tempo +
                    ", tempoConfidence=" + tempoConfidence +
                    ", timeSignature=" + timeSignature +
                    ", timeSignatureConfidence=" + timeSignatureConfidence +
                    ", key=" + key +
                    ", keyConfidence=" + keyConfidence +
                    ", mode=" + mode +
                    ", modeConfidence=" + modeConfidence +
                    ", codestring='" + codestring + '\'' +
                    ", codeVersion=" + codeVersion +
                    ", echoprintstring='" + echoprintstring + '\'' +
                    ", echoprintVersion=" + echoprintVersion +
                    ", synchstring='" + synchstring + '\'' +
                    ", synchVersion=" + synchVersion +
                    ", rhythmstring='" + rhythmstring + '\'' +
                    ", rhythmVersion=" + rhythmVersion +
                    '}';
        }
    }

    /**
     * Represents the time interval of a bar throughout the track. A bar (or measure) is a segment of time defined as a given number of beats.
     *
     * @param start      The starting point (in seconds) of the time interval.
     * @param duration   The duration (in seconds) of the time interval.
     * @param confidence The confidence, from 0.0 to 1.0, of the reliability of the interval.
     */
    public record Bar(float start, float duration, float confidence) implements AudioRecordArray, SpotifyObject {
        @Override
        public String toString() {
            return "Bar{" +
                    "start=" + start +
                    ", duration=" + duration +
                    ", confidence=" + confidence +
                    '}';
        }
    }

    /**
     * Represents the time interval of a beat throughout the track. A beat is the basic time unit of a piece of music;
     * for example, each tick of a metronome. Beats are typically multiples of tatums
     *
     * @param start      The starting point (in seconds) of the time interval.
     * @param duration   The duration (in seconds) of the time interval.
     * @param confidence The confidence, from 0.0 to 1.0, of the reliability of the interval.
     */
    public record Beat(float start, float duration, float confidence) implements AudioRecordArray, SpotifyObject {
        @Override
        public String toString() {
            return "Beat{" +
                    "start=" + start +
                    ", duration=" + duration +
                    ", confidence=" + confidence +
                    '}';
        }
    }

    /**
     * Represents a section, defined by large variations in rhythm or timbre, e.g. chorus, verse, bridge, guitar solo, etc.
     * Each section contains its own descriptions of tempo, key, mode, time_signature, and loudness.
     *
     * @param start                   The starting point (in seconds) of the section.
     * @param duration                The duration (in seconds) of the section.
     * @param confidence              The confidence, from 0.0 to 1.0, of the reliability of the section's "designation".
     * @param loudness                The overall loudness of the section in decibels (dB). Loudness values are useful for comparing
     *                                relative loudness of sections within tracks.
     * @param tempo                   The overall estimated tempo of the section in beats per minute (BPM). In musical terminology,
     *                                tempo is the speed or pace of a given piece and derives directly from the average beat duration.
     * @param tempoConfidence         The confidence, from 0.0 to 1.0, of the reliability of the tempo.
     *                                Some tracks contain tempo changes or sounds which don't contain tempo (like pure speech)
     *                                which would correspond to a low value in this field.
     * @param key                     The estimated overall key of the section. The values in this field ranging from 0 to 11 mapping to
     *                                pitches using standard Pitch Class notation (E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on).
     *                                If no key was detected, the value is -1.
     * @param keyConfidence           The confidence, from 0.0 to 1.0, of the reliability of the key.
     *                                Songs with many key changes may correspond to low values in this field.
     * @param mode                    Indicates the modality (major or minor) of a section, the type of scale from which its
     *                                melodic content is derived. This field will contain a 0 for "minor", a 1 for "major", or a -1 for no result.
     *                                Note that the major key (e.g. C major) could more likely be confused with the minor key at 3 semitones
     *                                lower (e.g. A minor) as both keys carry the same pitches.
     * @param modeConfidence          The confidence, from 0.0 to 1.0, of the reliability of the mode.
     * @param timeSignature           An estimated time signature. The time signature (meter) is a notational convention to
     *                                specify how many beats are in each bar (or measure).
     *                                The time signature ranges from 3 to 7 indicating time signatures of "3/4", to "7/4".
     * @param timeSignatureConfidence The confidence, from 0.0 to 1.0, of the reliability of the time_signature.
     *                                Sections with time signature changes may correspond to low values in this field.
     */
    public record Section(float start, float duration, float confidence, float loudness, float tempo,
                          float tempoConfidence, int key, float keyConfidence, float mode, float modeConfidence,
                          int timeSignature, float timeSignatureConfidence) implements AudioRecordArray, SpotifyObject {
        @Override
        public String toString() {
            return "Section{" +
                    "start=" + start +
                    ", duration=" + duration +
                    ", confidence=" + confidence +
                    ", loudness=" + loudness +
                    ", tempo=" + tempo +
                    ", tempoConfidence=" + tempoConfidence +
                    ", key=" + key +
                    ", keyConfidence=" + keyConfidence +
                    ", mode=" + mode +
                    ", modeConfidence=" + modeConfidence +
                    ", timeSignature=" + timeSignature +
                    ", timeSignatureConfidence=" + timeSignatureConfidence +
                    '}';
        }
    }

    /**
     * Represents each segment contains a roughly consistent sound throughout its duration.
     *
     * @param start           The starting point (in seconds) of the segment.
     * @param duration        The duration (in seconds) of the segment.
     * @param confidence      The confidence, from 0.0 to 1.0, of the reliability of the segmentation.
     *                        Segments of the song which are difficult to logically segment (e.g: noise) may correspond to
     *                        low values in this field.
     * @param loudnessStart   The onset loudness of the segment in decibels (dB). Combined with loudness_max and
     *                        loudness_max_time, these components can be used to describe the "attack" of the segment.
     * @param loudnessMax     The peak loudness of the segment in decibels (dB). Combined with loudness_start and
     *                        loudness_max_time, these components can be used to describe the "attack" of the segment.
     * @param loudnessMaxTime The segment-relative offset of the segment peak loudness in seconds.
     *                        Combined with loudness_start and loudness_max, these components can be used
     *                        to desctibe the "attack" of the segment.
     * @param loudnessEnd     The offset loudness of the segment in decibels (dB). This value should be equivalent to
     *                        the loudness_start of the following segment.
     * @param pitches         Pitch content is given by a "chroma" vector, corresponding to the 12 pitch classes C, C#, D to B,
     *                        with values ranging from 0 to 1 that describe the relative dominance of every pitch in the
     *                        chromatic scale. For example a C Major chord would likely be represented by large
     *                        values of C, E and G (i.e. classes 0, 4, and 7).
     *                        <p>
     *                        Vectors are normalized to 1 by their strongest dimension, therefore noisy sounds are likely represented by values
     *                        that are all close to 1, while pure tones are described by one value at 1 (the pitch) and others near 0.
     *                        As can be seen below, the 12 vector indices are a combination of low-power spectrum values at their respective pitch frequencies.
     * @param timbre          Timbre is the quality of a musical note or sound that distinguishes different types of musical instruments,
     *                        or voices. It is a complex notion also referred to as sound color, texture, or tone quality,
     *                        and is derived from the shape of a segment’s spectro-temporal surface, independently of pitch and loudness.
     *                        The timbre feature is a vector that includes 12 unbounded values roughly centered around 0.
     *                        Those values are high level abstractions of the spectral surface, ordered by degree of importance.
     *                        <p>
     *                        For completeness however, the first dimension represents the average loudness of the segment;
     *                        second emphasizes brightness;
     *                        third is more closely correlated to the flatness of a sound;
     *                        fourth to sounds with a stronger attack; etc.
     *                        See an image below representing the 12 basis functions (i.e. template segments).
     *                        <p>
     *                        The actual timbre of the segment is best described as a linear combination of these 12 basis functions
     *                        weighted by the coefficient values: timbre = c1 x b1 + c2 x b2 + ... + c12 x b12, where c1 to c12
     *                        represent the 12 coefficients and b1 to b12 the 12 basis functions as displayed below.
     *                        Timbre vectors are best used in comparison with each other.
     */
    public record Segment(float start, float duration, float confidence, float loudnessStart, float loudnessMax,
                          float loudnessMaxTime, float loudnessEnd, float[] pitches,
                          float[] timbre) implements AudioRecordArray, SpotifyObject {
        @Override
        public String toString() {
            return "Segment{" +
                    "start=" + start +
                    ", duration=" + duration +
                    ", confidence=" + confidence +
                    ", loudnessStart=" + loudnessStart +
                    ", loudnessMax=" + loudnessMax +
                    ", loudnessMaxTime=" + loudnessMaxTime +
                    ", loudnessEnd=" + loudnessEnd +
                    ", pitches=" + Arrays.toString(pitches) +
                    ", timbre=" + Arrays.toString(timbre) +
                    '}';
        }
    }

    /**
     * Represents a tatum, the lowest regular pulse train that a listener intuitively infers from the timing of
     * perceived musical events (segments).
     *
     * @param start      The starting point (in seconds) of the time interval.
     * @param duration   The duration (in seconds) of the time interval.
     * @param confidence The confidence, from 0.0 to 1.0, of the reliability of the interval.
     */
    public record Tatum(@SpotifyField(value = "start", type = Float.class) Float start,
                        @SpotifyField(value = "duration", type = Float.class) Float duration,
                        @SpotifyField(value = "confidence", type = Float.class) Float confidence) implements AudioRecordArray, SpotifyObject {
        @Override
        public String toString() {
            return "Tatum{" +
                    "start=" + start +
                    ", duration=" + duration +
                    ", confidence=" + confidence +
                    '}';
        }
    }
}
