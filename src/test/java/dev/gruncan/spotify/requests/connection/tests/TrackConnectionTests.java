package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import dev.gruncan.spotify.webapi.requests.tracks.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrackConnectionTests extends AbstractConnectionTest {

    @Test
    @Tag("NetworkTest")
    public void trackGetTest() {
        SpotifyRequestVariant request = new TrackGet("11dFghVXANMlKmJXsNCbNl");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void severalTracksGetTest() {
        SpotifyRequestVariant request = new TrackSeveralGet("7ouMYWpwJ422jRcDASZB7P", "4VqPOruhp5EdPBeR92t6lQ",
                "2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void severalTrackAudioFeaturesGetTest() {
        SpotifyRequestVariant request = new TrackAudioFeatureSeveralGet("7ouMYWpwJ422jRcDASZB7P", "4VqPOruhp5EdPBeR92t6lQ",
                "2takcwOaAZWiXQijPHIx7B");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void trackAudioFeaturesGetTest() {
        SpotifyRequestVariant request = new TrackAudioFeaturesGet("11dFghVXANMlKmJXsNCbNl");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void trackAudioAnalysisGetTest() {
        SpotifyRequestVariant request = new TrackAudioAnalysisGet("11dFghVXANMlKmJXsNCbNl");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void trackRecommendationGetTest() {
        SpotifyRequestVariant request = new TrackRecommendationGet(
                new String[]{"4NHQUGzhtTLFvgF5SZesLK"},
                new String[]{"classical", "country"},
                new String[]{"0c6xIDDpzE81m2q797ordA"});
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


}
