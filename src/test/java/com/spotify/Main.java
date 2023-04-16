package com.spotify;

import com.spotify.objects.search.Search;
import com.spotify.requests.search.SearchGet;
import com.spotify.requests.util.Type;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();


//        SeveralTracksGet severalTracksGet = new SeveralTracksGet("05lBXOMA1uHpVPEQZyjoh3", "4CeeEOM32jQcH3eN9Q2dGj");
        SearchGet searchGet = new SearchGet("remaster%20track:Doxy%20artist:Miles%20Davis", Type.TRACK);

        SpotifyResponse searchResponse = sc.executeRequest(searchGet);

        System.out.println(searchResponse.getRequestResponse().ok().toString(4));

        Search search = searchResponse.getSerialisedObject();


        System.out.println(search);


    }

}
