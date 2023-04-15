package com.spotify;

import com.spotify.objects.tracks.TrackAudioFeatures;
import com.spotify.requests.tracks.TrackAudioFeaturesGet;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();


//        SeveralTracksGet severalTracksGet = new SeveralTracksGet("05lBXOMA1uHpVPEQZyjoh3", "4CeeEOM32jQcH3eN9Q2dGj");
        TrackAudioFeaturesGet trackGet = new TrackAudioFeaturesGet("05lBXOMA1uHpVPEQZyjoh3");


//        SpotifyResponse sr = sc.executeRequest(severalTracksGet);
        SpotifyResponse trackResponse = sc.executeRequest(trackGet);


//        Track[] tracks = sr.getSerialisedObjects();
        TrackAudioFeatures track = trackResponse.getSerialisedObject();


//        System.out.println(Arrays.toString(tracks));
        System.out.println(track);


    }

}
