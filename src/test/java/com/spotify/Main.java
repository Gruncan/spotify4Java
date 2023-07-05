package com.spotify;

import com.spotify.objects.player.PlayerQueue;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.me.player.MyPlayerQueueGet;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();
        SpotifyRequestVariant request = new MyPlayerQueueGet();
        SpotifyResponse spotifyResponse = sc.executeRequest(request);
        String out = spotifyResponse.getJsonObject().toString(4);


        PlayerQueue playerQueue = spotifyResponse.getSerialisedObject();


        System.out.println(playerQueue);



    }



}
