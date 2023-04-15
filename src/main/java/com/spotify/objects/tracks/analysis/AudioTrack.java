package com.spotify.objects.tracks.analysis;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@SpotifyOptional
public class AudioTrack implements SpotifyObject {


    @SpotifyField("num_samples")
    private int numSamples;

    @SpotifyField
    private double duration;

    @SpotifyField("sample_md5")
    private String sampleMd5;

    @SpotifyField("offset_seconds")
    private int offsetSeconds;

    @SpotifyField("window_seconds")
    private int windowSeconds;

    @SpotifyField("analysis_sample_rate")
    private int analysisSampleRate;

    @SpotifyField("analysis_channels")
    private int analysisChannels;

    @SpotifyField("end_of_fade_in")
    private double endOfFadeIn;

    @SpotifyField("start_of_fade_out")
    private double startOfFadeOut;

    @SpotifyField
    private double loudness;

    @SpotifyField
    private double tempo;

    @SpotifyField("tempo_confidence")
    private double tempoConfidence;

    @SpotifyField("time_signature")
    private int timeSignature;

    @SpotifyField("time_signature_confidence")
    private double timeSignatureConfidence;

    @SpotifyField
    private int key;

    @SpotifyField("key_confidence")
    private double keyConfidence;

    @SpotifyField
    private int mode;

    @SpotifyField("mode_confidence")
    private double modeConfidence;

    @SpotifyField("codestring")
    private String code;

    @SpotifyField("code_version")
    private double codeVersion;

    @SpotifyField("echoprintstring")
    private String echoprint;

    @SpotifyField("echoprint_version")
    private double echoPrintVersion;

    @SpotifyField("synchstring")
    private String synch;

    @SpotifyField("synch_version")
    private double synchVersion;

    @SpotifyField("rhythmstring")
    private String rhythm;

    @SpotifyField("rhythm_version")
    private double rhythmVersion;

}
