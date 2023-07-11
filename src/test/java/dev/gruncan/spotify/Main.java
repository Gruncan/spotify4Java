package dev.gruncan.spotify;

import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.me.MyProfileGet;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();
        SpotifyRequestVariant request = new MyProfileGet();
        SpotifyResponse spotifyResponse = sc.executeRequest(request);
        String out = spotifyResponse.getJsonObject().toString(4);


        System.out.println(out);





    }



}
