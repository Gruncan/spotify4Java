package com.spotify;

import com.spotify.json.JSONObject;
import com.spotify.objects.track.TrackAlbum;
import com.spotify.requests.tracks.TrackGet;

public class Main {

    private static final String CLIENT_ID = "49d248093d8c41dd8b65aba37c5ef665";
    private static final String CLIENT_SECRET = "381ccdf476ac4584b0d936663d5c2232";
    private static final String REDIRECT_URL = "http://127.0.0.1:8888/redirect/";

    public static void main(String[] args) {
        SpotifyClient spotifyClient = new SpotifyClientBuilder(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL)
                .getBuiltClient();


        TrackGet trackGet = new TrackGet("2mgkRsjpp6HH1MTyHYpTeF");
        JSONObject jsonObject = spotifyClient.executeRequest(trackGet);
        TrackAlbum track = trackGet.serialize(jsonObject);
        System.out.println(track.toString());


    }

}
