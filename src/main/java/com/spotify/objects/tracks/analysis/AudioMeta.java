package com.spotify.objects.tracks.analysis;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AudioMeta implements SpotifyObject {


    @SpotifyField("analyzer_version")
    private String analyzerVersion;

    @SpotifyField
    private String platform;

    @SpotifyField("detailed_status")
    private String detailedStatus;

    @SpotifyField("status_code")
    private int statusCode;

    @SpotifyField
    private int timestamp;

    @SpotifyField("analysis_time")
    private double analysisTime;

    @SpotifyField("input_process")
    private String inputProcess;

}
