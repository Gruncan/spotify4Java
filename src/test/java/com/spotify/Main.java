package com.spotify;

import com.spotify.objects.wrappers.SpotifyBooleanArray;
import com.spotify.requests.me.MyFollowingPersonGet;

import java.io.IOException;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();
        MyFollowingPersonGet request = new MyFollowingPersonGet("artist", "3zz52ViyCBcplK0ftEVPSS", "5K4W6rqBFWDnAN6FQUkS6x");
        SpotifyResponse spotifyResponse = sc.executeRequest(request);
        String out = spotifyResponse.getJsonObject().toString(4);


        System.out.println(out);
        SpotifyBooleanArray pageAlbums = spotifyResponse.getSerialisedObject();
        System.out.println(Arrays.toString(pageAlbums.getValues()));

    }



}
