package com.spotify;

import com.json.JSONObject;
import com.spotify.requests.search.SearchGet;
import com.spotify.requests.util.Type;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().printAccessToken().getBuiltClient();

        SearchGet searchGet = new SearchGet("Don't Stop artist:Fleetwood Mac", Type.TRACK);
//        AbstractRequest al = new SeveralTrackAudioFeaturesGet("05lBXOMA1uHpVPEQZyjoh3", "1ljziaoMnRH95aPeOSGAtr1");

        System.out.println(searchGet.buildRequestUrl());
        JSONObject jsonObject = sc.executeRequest(searchGet).ok();
        System.out.println(jsonObject.toString(4));


    }

}
