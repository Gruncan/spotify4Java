package dev.gruncan.spotify.api.web.objects.tracks.analysis;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.SpotifyOptional;
import dev.gruncan.spotify.api.web.objects.tracks.TrackAudioAnalysis;
import lombok.Getter;
import lombok.Setter;

/**
 * The audio meta data associated with a track
 *
 * @see TrackAudioAnalysis
 * @see SpotifyObject
 */
@Getter
@Setter
@SpotifyOptional
public class AudioMeta implements SpotifyObject {

    /**
     * The version of the Analyzer used to analyze this track.
     */
    @SpotifyField("analyzer_version")
    private String analyzerVersion;

    /**
     * The platform used to read the track's audio data.
     */
    @SpotifyField
    private String platform;

    /**
     * A detailed status code for this track. If analysis data is missing, this code may explain why.
     */
    @SpotifyField("detailed_status")
    private String detailedStatus;

    /**
     * The return code of the analyzer process. 0 if successful, 1 if any errors occurred.
     */
    @SpotifyField("status_code")
    private int statusCode;

    /**
     * The Unix timestamp (in seconds) at which this track was analyzed.
     */
    @SpotifyField
    private int timestamp;

    /**
     * The amount of time taken to analyze this track.
     */
    @SpotifyField("analysis_time")
    private double analysisTime;

    /**
     * The method used to read the track's audio data.
     */
    @SpotifyField("input_process")
    private String inputProcess;

}
