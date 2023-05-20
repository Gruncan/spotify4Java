package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.tracks.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrackTests extends AbstractConnectionTest {

    @Test
    @Tag("NetworkTest")
    public void trackGetTest() {
        AbstractRequest request = new TrackGet("11dFghVXANMlKmJXsNCbNl");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void severalTracksGetTest() {
        AbstractRequest request = new SeveralTracksGet("7ouMYWpwJ422jRcDASZB7P", "4VqPOruhp5EdPBeR92t6lQ",
                "2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void severalTrackAudioFeaturesGetTest() {
        AbstractRequest request = new SeveralTrackAudioFeaturesGet("7ouMYWpwJ422jRcDASZB7P", "4VqPOruhp5EdPBeR92t6lQ",
                "2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void trackAudioFeaturesGetTest() {
        AbstractRequest request = new TrackAudioFeaturesGet("11dFghVXANMlKmJXsNCbNl");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void trackAudioAnalysisGetTest() {
        AbstractRequest request = new TrackAudioAnalysisGet("11dFghVXANMlKmJXsNCbNl");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void trackRecommendationGetTest() {
        AbstractRequest request = new TrackRecommendationGet(
                new String[]{"4NHQUGzhtTLFvgF5SZesLK"},
                new String[]{"classical", "country"},
                new String[]{"0c6xIDDpzE81m2q797ordA"});
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


}
