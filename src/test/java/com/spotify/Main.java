package com.spotify;

import com.spotify.requests.playlists.PlaylistAddCoverImagePut;

import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();
        PlaylistAddCoverImagePut request = new PlaylistAddCoverImagePut("5WZVv7mYthzwwCN001nJXb", new File("C:\\Users\\DJ223\\Pictures\\test.jpeg"));

        sc.executeRequest(request);

    }

}
