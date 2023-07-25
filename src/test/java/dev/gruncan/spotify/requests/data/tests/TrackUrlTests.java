package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import dev.gruncan.spotify.webapi.requests.tracks.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackUrlTests extends AbstractUrlTest {

    @Test
    public void trackGetTestUrl() {
        SpotifyRequestVariant request = new TrackGet("11dFghVXANMlKmJXsNCbNl");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void severalTracksGetTestUrl() {
        SpotifyRequestVariant request = new TrackSeveralGet("7ouMYWpwJ422jRcDASZB7P", "4VqPOruhp5EdPBeR92t6lQ",
                "2takcwOaAZWiXQijPHIx7B");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void severalTrackAudioFeaturesGetTestUrl() {
        SpotifyRequestVariant request = new TrackAudioFeatureSeveralGet("7ouMYWpwJ422jRcDASZB7P", "4VqPOruhp5EdPBeR92t6lQ",
                "2takcwOaAZWiXQijPHIx7B");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void trackAudioFeaturesGetTestUrl() {
        SpotifyRequestVariant request = new TrackAudioFeaturesGet("11dFghVXANMlKmJXsNCbNl");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void trackAudioAnalysisGetTestUrl() {
        SpotifyRequestVariant request = new TrackAudioAnalysisGet("11dFghVXANMlKmJXsNCbNl");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void trackRecommendationGetTestUrl() {
        SpotifyRequestVariant request = new TrackRecommendationGet(
                new String[]{"4NHQUGzhtTLFvgF5SZesLK"},
                new String[]{"classical", "country"},
                new String[]{"0c6xIDDpzE81m2q797ordA"});
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }


}
