package com.spotify.objects.tracks.analysis;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SpotifyOptional
public class AudioSection implements SpotifyObject {


    @SpotifyField
    private double number;

    @SpotifyField
    private double duration;

    @SpotifyField
    private double confidence;

    @SpotifyField
    private double loudness;

    @SpotifyField
    private double tempo;

    @SpotifyField("tempo_confidence")
    private double tempConfidence;

    @SpotifyField
    private int key;

    @SpotifyField("key_confidence")
    private double keyConfidence;

    @SpotifyField
    private double mode;

    @SpotifyField("mode_confidence")
    private double modeConfidence;

    @SpotifyField("time_signature")
    private int timeSignature;

    @SpotifyField("time_signature_confidence")
    private double timeSignatureConfidence;


}
