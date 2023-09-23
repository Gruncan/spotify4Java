package dev.gruncan.spotify;

import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.me.MyFollowPersonPut;
import dev.gruncan.spotify.api.web.requests.me.MyProfileGet;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        SpotifyClient sc = new SpotifyClientBuilderTester().printAccessToken().getBuiltClient();
        SpotifyRequestVariant request = new MyProfileGet();
        SpotifyResponse spotifyResponse = sc.executeRequest(request);
        String out = spotifyResponse.getJsonObject().toString(4);


        System.out.println(out);





    }



}
