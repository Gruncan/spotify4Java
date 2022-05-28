package com.spotify.objects.track;


/**
 * Represents a spotify's track audio features
 */
public class TrackAudioFeatures {


    /**
     * A confidence measure from 0.0 to 1.0 of whether the track is acoustic. 1.0 represents high confidence
     * the track is acoustic.>= 0 <= 1
     */
    private final float acousticness;

    /**
     * A URL to access the full audio analysis of this track. An access token is required to access this data.
     */
    private final String analysisUrl;

    /**
     * Danceability describes how suitable a track is for dancing based on a combination of musical elements including
     * tempo, rhythm stability, beat strength, and overall regularity. A value of 0.0 is least danceable and 1.0 is most danceable.
     */
    private final float danceability;

    /**
     * The duration of the track in milliseconds.
     */
    private final int durationMs;

    /**
     * Energy is a measure from 0.0 to 1.0 and represents a perceptual measure of intensity and activity.
     * Typically, energetic tracks feel fast, loud, and noisy. For example, death metal has high energy,
     * while a Bach prelude scores low on the scale.
     * Perceptual features contributing to this attribute include dynamic range, perceived loudness, timbre,
     * onset rate, and general entropy.
     */
    private final float energy;

    /**
     * The Spotify ID for the track.
     */
    private final String id;

    /**
     * Predicts whether a track contains no vocals. "Ooh" and "aah" sounds are treated as instrumental in this context.
     * Rap or spoken word tracks are clearly "vocal". The closer the instrumentalness value is to 1.0,
     * the greater likelihood the track contains no vocal content. Values above 0.5 are intended to
     * represent instrumental tracks, but confidence is higher as the value approaches 1.0.
     */
    private final float instrumentalness;

    /**
     * The key the track is in. Integers map to pitches using standard
     * <a href="https://en.wikipedia.org/wiki/Pitch_class">Pitch Class notation</a>.
     * E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on. If no key was detected, the value is -1. >= -1<= 11
     */
    private final int key;

    /**
     * Detects the presence of an audience in the recording. Higher liveness values represent an increased probability
     * that the track was performed live. A value above 0.8 provides strong likelihood that the track is live.
     */
    private final float liveness;

    /**
     * The overall loudness of a track in decibels (dB). Loudness values are averaged across the entire track and are
     * useful for comparing relative loudness of tracks. Loudness is the quality of a sound that is the
     * primary psychological correlate of physical strength (amplitude). Values typically range between -60 and 0 db.
     */
    private final float loudness;

    /**
     * Mode indicates the modality (major or minor) of a track, the type of scale from which its
     * melodic content is derived. Major is represented by 1 and minor is 0.
     */
    private final int mode;

    /**
     * Speechiness detects the presence of spoken words in a track. The more exclusively speech-like the recording
     * (e.g. talk show, audio book, poetry), the closer to 1.0 the attribute value.
     * Values above 0.66 describe tracks that are probably made entirely of spoken words.
     * Values between 0.33 and 0.66 describe tracks that may contain both music and speech, either in sections or layered,
     * including such cases as rap music. Values below 0.33 most likely represent music and other non-speech-like tracks.
     */
    private final float speechiness;

    /**
     * The overall estimated tempo of a track in beats per minute (BPM). In musical terminology,
     * tempo is the speed or pace of a given piece and derives directly from the average beat duration.
     */
    private final float tempo;

    /**
     * An estimated time signature. The time signature (meter) is a notational convention to specify how many beats
     * are in each bar (or measure). The time signature ranges from 3 to 7 indicating time signatures of "3/4", to "7/4".
     * >= 3<= 7
     */
    private final int timeSignature;

    /**
     * A link to the Web API endpoint providing full details of the track.
     */
    private final String trackHref;

    /**
     * The object type. Allowed value:"audio_features"
     */
    private final String type;

    /**
     * The Spotify URI for the track.
     */
    private final String uri;

    /**
     * A measure from 0.0 to 1.0 describing the musical positiveness conveyed by a track.
     * Tracks with high valence sound more positive (e.g. happy, cheerful, euphoric),
     * while tracks with low valence sound more negative (e.g. sad, depressed, angry).
     * >= 0<= 1
     */
    private final float valence;

    /**
     * @param acousticness     A confidence measure from {@code 0.0} to {@code 1.0} of whether the track is acoustic.
     *                         {@code 1.0} represents high confidence the track is acoustic. {@code >= 0 <= 1}
     * @param analysisUrl      A URL to access the full audio analysis of this track. An access token is required to access
     *                         this data.
     * @param danceability     Danceability describes how suitable a track is for dancing based on a combination of musical
     *                         elements including tempo, rhythm stability, beat strength, and overall regularity.
     *                         A value of {@code 0.0} is least danceable and {@code 1.0} is most danceable.
     * @param durationMs       The duration of the track in milliseconds.
     * @param energy           Energy is a measure from {@code 0.0} to {@code 1.0} and represents a perceptual measure of intensity and activity.
     *                         Typically, energetic tracks feel fast, loud, and noisy. For example, death metal has high energy,
     *                         while a Bach prelude scores low on the scale.
     *                         Perceptual features contributing to this attribute include dynamic range, perceived loudness, timbre,
     *                         onset rate, and general entropy.
     * @param id               The Spotify ID for the track.
     * @param instrumentalness Predicts whether a track contains no vocals. "Ooh" and "aah" sounds are treated as instrumental in this context.
     *                         Rap or spoken word tracks are clearly "vocal". The closer the instrumentalness value is to {@code 1.0},
     *                         the greater likelihood the track contains no vocal content. Values above {@code 0.5} are intended to
     *                         represent instrumental tracks, but confidence is higher as the value approaches {@code 1.0}.
     * @param key              The key the track is in. Integers map to pitches using standard
     *                         <a href="https://en.wikipedia.org/wiki/Pitch_class">Pitch Class notation</a>.
     *                         E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on. If no key was detected, the value is {@code -1. >= -1 <= 11}
     * @param liveness         Detects the presence of an audience in the recording. Higher liveness values represent an
     *                         increased probability that the track was performed live.
     *                         A value above 0.8 provides strong likelihood that the track is live.
     * @param loudness         The overall loudness of a track in decibels (dB). Loudness values are averaged across the entire
     *                         track and are useful for comparing relative loudness of tracks. Loudness is the quality of a sound
     *                         that is the primary psychological correlate of physical strength (amplitude).
     *                         Values typically range between {@code -60} and {@code 0} db.
     * @param mode             Mode indicates the modality (major or minor) of a track, the type of scale from which its
     *                         melodic content is derived. Major is represented by {@code 1} and minor is {@code 0}.
     * @param speechiness      Speechiness detects the presence of spoken words in a track. The more exclusively speech-like the recording
     *                         (e.g. talk show, audio book, poetry), the closer to {@code 1.0} the attribute value.
     *                         Values above {@code 0.66} describe tracks that are probably made entirely of spoken words.
     *                         Values between {@code 0.33} and {@code 0.66} describe tracks that may contain both music and speech, either in sections or layered,
     *                         including such cases as rap music. Values below {@code 0.33} most likely represent music and other non-speech-like tracks.
     * @param tempo            The overall estimated tempo of a track in beats per minute (BPM). In musical terminology,
     *                         tempo is the speed or pace of a given piece and derives directly from the average beat duration.
     * @param timeSignature    An estimated time signature. The time signature (meter) is a notational convention to specify how many beats
     *                         are in each bar (or measure).
     *                         The time signature ranges from {@code 3} to {@code 7} indicating time signatures of "{@code 3/4}", to "{@code 7/4}".
     *                         {@code >= 3<= 7 }
     * @param trackHref        A link to the Web API endpoint providing full details of the track.
     * @param type             The object type. Allowed value:"audio_features"
     * @param uri              The Spotify URI for the track.
     * @param valence          A measure from {@code 0.0} to {@code 1.0} describing the musical positiveness conveyed by a track.
     *                         Tracks with high valence sound more positive (e.g. happy, cheerful, euphoric),
     *                         while tracks with low valence sound more negative (e.g. sad, depressed, angry).
     *                         {@code >= 0<= 1}
     */
    public TrackAudioFeatures(float acousticness, String analysisUrl, float danceability, int durationMs, float energy,
                              String id, float instrumentalness, int key, float liveness, float loudness, int mode,
                              float speechiness, float tempo, int timeSignature, String trackHref, String type,
                              String uri, float valence) {
        this.acousticness = acousticness;
        this.analysisUrl = analysisUrl;
        this.danceability = danceability;
        this.durationMs = durationMs;
        this.energy = energy;
        this.id = id;
        this.instrumentalness = instrumentalness;
        this.key = key;
        this.liveness = liveness;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.tempo = tempo;
        this.timeSignature = timeSignature;
        this.trackHref = trackHref;
        this.type = type;
        this.uri = uri;
        this.valence = valence;
    }

    public float getAcousticness() {
        return acousticness;
    }

    public String getAnalysisUrl() {
        return analysisUrl;
    }

    public float getDanceability() {
        return danceability;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public float getEnergy() {
        return energy;
    }

    public String getId() {
        return id;
    }

    public float getInstrumentalness() {
        return instrumentalness;
    }

    public int getKey() {
        return key;
    }

    public float getLiveness() {
        return liveness;
    }

    public float getLoudness() {
        return loudness;
    }

    public int getMode() {
        return mode;
    }

    public float getSpeechiness() {
        return speechiness;
    }

    public float getTempo() {
        return tempo;
    }

    public int getTimeSignature() {
        return timeSignature;
    }

    public String getTrackHref() {
        return trackHref;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public float getValence() {
        return valence;
    }
}
