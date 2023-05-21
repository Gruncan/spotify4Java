package com.spotify.requests.data;

/**
 * Designed to be run once before release to checked data is correct.
 */
public class RetrieveSpotifyData {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.spotify.requests.tracks.TrackRecommendationGet");
    }
}
