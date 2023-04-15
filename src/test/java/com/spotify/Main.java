package com.spotify;

import com.spotify.objects.tracks.Track;
import com.spotify.requests.tracks.SeveralTracksGet;
import com.spotify.requests.tracks.TrackGet;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();


        SeveralTracksGet severalTracksGet = new SeveralTracksGet("05lBXOMA1uHpVPEQZyjoh3", "4CeeEOM32jQcH3eN9Q2dGj");
        TrackGet trackGet = new TrackGet("1ljziaoMnRH95aPeOSGAtr1");


//        SpotifyResponse sr = sc.executeRequest(severalTracksGet);
        SpotifyResponse trackResponse = sc.executeRequest(trackGet);


//        Track[] tracks = sr.getSerialisedObjects();
        Track[] track = trackResponse.getSerialisedObjects();

//        System.out.println(Arrays.toString(tracks));
        System.out.println(track);


    }

}
