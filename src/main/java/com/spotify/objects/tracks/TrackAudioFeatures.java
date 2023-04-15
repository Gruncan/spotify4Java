package com.spotify.objects.tracks;


import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SpotifyOptional
public class TrackAudioFeatures implements SpotifyObject {

    @SpotifyField
    private double acousticness;

    @SpotifyField("analysis_url")
    private String analysisUrl;

    @SpotifyField
    private double danceability;

    @SpotifyField("duration_ms")
    private int duration;

    @SpotifyField
    private double energy;

    @SpotifyField
    private String id;

    @SpotifyField
    private double instrumentalness;

    @SpotifyField
    private int key;

    @SpotifyField
    private double liveness;

    @SpotifyField
    private double loudness;

    @SpotifyField
    private int mode;

    @SpotifyField
    private double speechiness;

    @SpotifyField
    private double tempo;

    @SpotifyField("time_signature")
    private int timeSignature;

    @SpotifyField("track_href")
    private String trackHref;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

    @SpotifyField
    private double valence;


}
