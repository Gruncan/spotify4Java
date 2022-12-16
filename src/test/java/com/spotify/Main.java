package com.spotify;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.tracks.SeveralTrackAudioFeaturesGet;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();


        AbstractRequest al = new SeveralTrackAudioFeaturesGet("05lBXOMA1uHpVPEQZyjoh3", "1ljziaoMnRH95aPeOSGAtr1");

        JSONObject jsonObject = sc.executeRequest(al).ok();
        System.out.println(jsonObject.toString(4));


    }

}
