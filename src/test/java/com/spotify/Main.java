package com.spotify;

import com.spotify.objects.artists.PageArtists;
import com.spotify.requests.me.MyFollowedArtistsGet;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();
        MyFollowedArtistsGet request = new MyFollowedArtistsGet();

        SpotifyResponse spotifyResponse = sc.executeRequest(request);
        String out = spotifyResponse.getJsonObject().toString(4);


        System.out.println(out);
        PageArtists pageAlbums = spotifyResponse.getSerialisedObject();
        System.out.println(pageAlbums.toString());

    }

}
