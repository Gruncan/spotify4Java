package dev.gruncan.spotify;

import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.me.MyFollowPersonPut;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        SpotifyClient sc = new SpotifyClientBuilderTester().printAccessToken().getBuiltClient();
        SpotifyRequestVariant request = new MyFollowPersonPut("artist", "2CIMQHirSU0MQqyYHq0eOx","57dN52uHvrHOxijzpIgu3E","1vCWHaC5f2uS3yhpwWbIA6");
        SpotifyResponse spotifyResponse = sc.executeRequest(request);
        String out = spotifyResponse.getJsonObject().toString(4);


        System.out.println(out);





    }



}
