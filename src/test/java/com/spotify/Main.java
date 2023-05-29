package com.spotify;

import com.spotify.objects.playlists.PlaylistTracksSearch;
import com.spotify.requests.playlists.PlaylistTracksGet;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();

        PlaylistTracksGet request = new PlaylistTracksGet("3cEYpjA9oz9GiPac4AsH4n");

        SpotifyResponse sp = sc.executeRequest(request);

        PlaylistTracksSearch playlistTrack = sp.getSerialisedObject();

        System.out.println(Arrays.toString(playlistTrack.getItems()));


    }

}
