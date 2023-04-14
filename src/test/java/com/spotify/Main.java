package com.spotify;

import com.spotify.objects.tracks.Track;
import com.spotify.requests.tracks.TrackGet;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().printAccessToken().getBuiltClient();

//        SearchGet searchGet = new SearchGet("Don't Stop artist:Fleetwood Mac", Type.TRACK);
//        AbstractRequest al = new SeveralTrackAudioFeaturesGet("05lBXOMA1uHpVPEQZyjoh3", "1ljziaoMnRH95aPeOSGAtr1");

        TrackGet trackGet = new TrackGet("05lBXOMA1uHpVPEQZyjoh3");


        SpotifyResponse spotifyResponse = sc.executeRequest(trackGet);
        Track track = spotifyResponse.getSerialisedObject();

        System.out.println(track);


    }

}
