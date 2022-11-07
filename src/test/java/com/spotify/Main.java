package com.spotify;

import com.spotify.json.JSONObject;
import com.spotify.requests.albums.AlbumsSavedMeGet;

public class Main {

    private static final String CLIENT_ID = "49d248093d8c41dd8b65aba37c5ef665";
    private static final String CLIENT_SECRET = "381ccdf476ac4584b0d936663d5c2232";
    private static final String REDIRECT_URL = "http://127.0.0.1:8888/redirect/";

    public static void main(String[] args) throws IllegalAccessException {
        SpotifyClient spotifyClient = new SpotifyClientBuilder(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL)
                .printAccessToken()
                .getBuiltClient();

//        SpotifyClient spotifyClient = SpotifyClientBuilder.buildFromToken("BQCcVsMYETyr6W-Fs0pS50oxEtDw1TVbZVcLEqZj3VUVAEKbpID9EnQys1f0Nvd6SRu-whdTJabKaTp1I0kJYZ4K9W645SG08deHOL35tMIlvBbeMBpP8tbgRhgUFce1jPB4iPXwoASSJ0otYCL7BCBC4C2jG2fQ0NPfeNHDaJZ9voY");

//        AbstractRequest trackGet = new TrackGet("2mgkRsjpp6HH1MTyHYpTeF");
//        JSONObject jsonObject = spotifyClient.executeRequest(trackGet);
//        System.out.println(jsonObject.toString(4));

        AlbumsSavedMeGet al = new AlbumsSavedMeGet();

        JSONObject jsonObject = spotifyClient.executeRequest(al);
        System.out.println(jsonObject.toString(4));


    }

}
