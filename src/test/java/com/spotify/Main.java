package com.spotify;

import com.json.JSONObject;
import com.spotify.objects.tracks.Track;
import com.spotify.requests.tracks.TrackGet;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().printAccessToken().getBuiltClient();

//        SearchGet searchGet = new SearchGet("Don't Stop artist:Fleetwood Mac", Type.TRACK);
//        AbstractRequest al = new SeveralTrackAudioFeaturesGet("05lBXOMA1uHpVPEQZyjoh3", "1ljziaoMnRH95aPeOSGAtr1");

        TrackGet trackGet = new TrackGet("05lBXOMA1uHpVPEQZyjoh3");

        JSONObject jsonObject = sc.executeRequest(trackGet).ok();

        SpotifySerializer ss = new SpotifySerializer();

        Track track = ss.serializer(Track.class, jsonObject);

        System.out.println(track);


    }

}
