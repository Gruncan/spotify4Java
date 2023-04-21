package com.spotify;

import com.json.JSONObject;
import com.spotify.objects.albums.AlbumTracks;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.artists.SimplifiedArtist;
import com.spotify.objects.search.Search;
import com.spotify.objects.tracks.SimplifiedTrack;
import com.spotify.objects.tracks.Track;
import com.spotify.requests.albums.AlbumTracksGet;
import com.spotify.requests.search.SearchGet;
import com.spotify.requests.tracks.TrackGet;
import com.spotify.requests.util.Type;

import javax.lang.model.SourceVersion;
import java.util.Arrays;

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


//        SearchGet searchGet = new SearchGet("Don't Stop artist:Fleetwood Mac", Type.TRACK);
//
//
//        SpotifyResponse sp = sc.executeRequest(searchGet);
//
//
//        Search search = sp.getSerialisedObject();
//
//        System.out.println(search);

//        SeveralAlbumsGet albumGet = new SeveralAlbumsGet("382ObEPsp2rxGrnsizN5TX", "1A2GTWGtFfWp7KSQTwWOyo", "2noRn2Aes5aoNVsU6iWThc");
//        SpotifyResponse spotifyResponse = sc.executeRequest(albumGet);
//
//        Album[] album = spotifyResponse.getSerialisedObjects();
//
//
//        System.out.println(Arrays.toString(album));


//        TrackGet trackGet = new TrackGet("05lBXOMA1uHpVPEQZyjoh3");
//
//        SpotifyResponse sp = sc.executeRequest(trackGet);
////
//        System.out.println(sp.getJsonObject().toString(4));

//        Track track = sp.getSerialisedObject();
//
//        Artist[] artists = track.getArtists();
//
//        SimplifiedTrack track1 = ((SimplifiedTrack) track);
//
//        SimplifiedArtist[] sArtists = track1.getSimplifiedArtists();
//
//
//        System.out.println(Arrays.toString(artists));
//        System.out.println(Arrays.toString(sArtists));

        AlbumTracksGet albumTracksGet = new AlbumTracksGet("6d1vGZsr6Uy3h9IigBpPAf");

        SpotifyResponse sp = sc.executeRequest(albumTracksGet);
        AlbumTracks albumTracks = sp.getSerialisedObject();

        System.out.println(albumTracks.toString());


    }

}
