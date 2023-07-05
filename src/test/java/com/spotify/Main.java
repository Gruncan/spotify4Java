package com.spotify;

import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.playlists.PlaylistAddItemPost;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();
        SpotifyRequestVariant request = new PlaylistAddItemPost("3NEEvJ4ZEy1qbPggJBxCBf","spotify:track:1odExI7RdWc4BT515LTAwj");
        SpotifyResponse spotifyResponse = sc.executeRequest(request);
        String out = spotifyResponse.getJsonObject().toString(4);


        System.out.println(out);





    }



}
