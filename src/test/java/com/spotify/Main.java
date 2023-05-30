package com.spotify;

import com.spotify.requests.playlists.FollowPlaylistPut;

public class Main {


    public static void main(String[] args) {
        SpotifyClient sc = new SpotifyClientBuilderTester().getBuiltClient();

        FollowPlaylistPut request = new FollowPlaylistPut("37i9dQZF1E8Fz3Y6IBuffG");

        SpotifyResponse response = sc.executeRequest(request);

        System.out.println(response.getJsonObject().toString(4));

    }

}
