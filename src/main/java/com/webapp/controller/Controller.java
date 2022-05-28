package com.webapp.controller;


import com.spotify.SpotifyClient;
import com.spotify.SpotifyClientBuilder;
import com.spotify.json.JSONObject;
import com.spotify.objects.SerializeObject;
import com.spotify.objects.track.Track;
import com.spotify.objects.track.TrackAudioAnalysis;
import com.spotify.objects.track.TrackAudioFeatures;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.tracks.TrackAudioAnalysisGet;
import com.spotify.requests.tracks.TrackAudioFeaturesGet;
import com.spotify.requests.tracks.TrackGet;
import com.spotify.requests.util.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class Controller {


    private static final String CLIENT_ID = "49d248093d8c41dd8b65aba37c5ef665";
    private static final String CLIENT_SECRET = "381ccdf476ac4584b0d936663d5c2232";
    private static final String REDIRECT_URL = "http://127.0.0.1:8888/redirect/";

    private final SpotifyClientBuilder scb;


    public Controller() {
        this.scb = new SpotifyClientBuilder(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL).setResponseType("code").addScope(Scope.USER_READ_PRIVATE, Scope.USER_READ_EMAIL, Scope.USER_LIBRARY_READ, Scope.USER_TOP_READ);
    }

    @GetMapping("/")
    public String welcome() {
        return "TestPage";
    }

    @GetMapping(value = "/spot/")
    public void spot(HttpServletResponse httpServletResponse) {
        // after going to "/spot/" redirects to spotify login
        String url_auth = scb.buildAuthUrl();
        httpServletResponse.setHeader("Location", url_auth);
        httpServletResponse.setStatus(302);
    }

    @GetMapping("/redirect/")
    public String redirect(@RequestParam String code) {
        SpotifyClient spotifyClient = scb.build(code);

        AbstractRequest analysisRequest = new TrackAudioAnalysisGet("254bXAqt3zP6P50BdQvEsq");
        AbstractRequest featuresRequest = new TrackAudioFeaturesGet("254bXAqt3zP6P50BdQvEsq");
        AbstractRequest trackRequest = new TrackGet("254bXAqt3zP6P50BdQvEsq");

        JSONObject jsonAnalysis = spotifyClient.executeRequest(analysisRequest);
        JSONObject jsonFeatures = spotifyClient.executeRequest(featuresRequest);
        JSONObject jsonTrack = spotifyClient.executeRequest(trackRequest);

        SerializeObject so = new SerializeObject();

        TrackAudioAnalysis trackAudioAnalysis = so.serializeTrackAudioAnalysis(jsonAnalysis);
        TrackAudioFeatures trackAudioFeatures = so.serializeTrackAudioFeatures(jsonFeatures);
        Track track = so.serializeTrack(jsonTrack);
        track.setAudioAnalysis(trackAudioAnalysis);
        track.setAudioFeatures(trackAudioFeatures);

        System.out.println(track);

        return "RedirectPage";

    }



}