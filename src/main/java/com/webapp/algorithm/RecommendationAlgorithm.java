package com.webapp.algorithm;

import com.spotify.SpotifyClient;
import com.spotify.objects.track.Track;

public class RecommendationAlgorithm {


    private final SpotifyClient spotifyClient;
    private Track[] tracks;

    public RecommendationAlgorithm(SpotifyClient spotifyClient) {
        this.spotifyClient = spotifyClient;
    }


    public void loadTracks(String[] ids) {

    }


}
