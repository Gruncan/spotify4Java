package com.spotify;

import com.spotify.objects.tracks.TrackAudioAnalysis;
import com.spotify.requests.tracks.TrackAudioAnalysisGet;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();


//        SeveralTracksGet severalTracksGet = new SeveralTracksGet("05lBXOMA1uHpVPEQZyjoh3", "4CeeEOM32jQcH3eN9Q2dGj");
        TrackAudioAnalysisGet trackGet = new TrackAudioAnalysisGet("4CeeEOM32jQcH3eN9Q2dGj");

        SpotifyResponse trackResponse = sc.executeRequest(trackGet);


        TrackAudioAnalysis tracks = trackResponse.getSerialisedObject();


        System.out.println(tracks);


    }

}
