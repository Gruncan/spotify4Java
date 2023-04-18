package com.spotify;

import com.spotify.objects.search.Search;
import com.spotify.requests.search.SearchGet;
import com.spotify.requests.util.Type;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();


//        SeveralTracksGet severalTracksGet = new SeveralTracksGet("05lBXOMA1uHpVPEQZyjoh3", "4CeeEOM32jQcH3eN9Q2dGj");
//        SearchGet searchGet = new SearchGet("remaster%20track:Doxy%20artist:Miles%20Davis", Type.TRACK);
//
//        SpotifyResponse searchResponse = sc.executeRequest(searchGet);
//
//        System.out.println(searchResponse.getRequestResponse().ok().toString(4));
//
//        Search search = searchResponse.getSerialisedObject();

//
//        String[] seedArtists = {"4NHQUGzhtTLFvgF5SZesLK"};
//        String[] seedGenres = {"classic", "country"};
//        String[] seedTracks = {"0c6xIDDpzE81m2q797ordA"};
//        TrackRecommendationGet trg = new TrackRecommendationGet(seedArtists, seedGenres, seedTracks);
//
//        trg.setLimit(10);
//        trg.setMarket(Market.ES);
//
//
//        SpotifyResponse sp = sc.executeRequest(trg);
//
//        TrackRecommendation trackRecommendation = sp.getSerialisedObject();
//
//        System.out.println(trackRecommendation);


        SearchGet searchGet = new SearchGet("Don't Stop artist:Fleetwood Mac", Type.TRACK);


        SpotifyResponse sp = sc.executeRequest(searchGet);


        Search search = sp.getSerialisedObject();

        System.out.println(search);

    }

}
