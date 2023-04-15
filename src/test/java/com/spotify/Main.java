package com.spotify;

import com.spotify.objects.tracks.TrackAudioFeatures;
import com.spotify.requests.tracks.SeveralTrackAudioFeaturesGet;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();


//        SeveralTracksGet severalTracksGet = new SeveralTracksGet("05lBXOMA1uHpVPEQZyjoh3", "4CeeEOM32jQcH3eN9Q2dGj");
        SeveralTrackAudioFeaturesGet trackGet = new SeveralTrackAudioFeaturesGet("05lBXOMA1uHpVPEQZyjoh3", "4CeeEOM32jQcH3eN9Q2dGj");


//        SpotifyResponse sr = sc.executeRequest(severalTracksGet);
        SpotifyResponse trackResponse = sc.executeRequest(trackGet);

        TrackAudioFeatures[] tracks = trackResponse.getSerialisedObjects();


        System.out.println(Arrays.toString(tracks));


    }

}
