package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import dev.gruncan.spotify.api.web.requests.episodes.EpisodeGet;
import dev.gruncan.spotify.api.web.requests.episodes.EpisodeSeveralGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EpisodeConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void episodeGetTest() {
        SpotifyRequestVariant request = new EpisodeGet("512ojhOuo1ktJprKbVcKyQ");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


    @Test
    @Tag("NetworkTest")
    public void severalEpisodeGetTest() {
        SpotifyRequestVariant request = new EpisodeSeveralGet("77o6BIVlYM3msb4MMIL1jH", "0Q86acNRm6V9GYx55SXKwf");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
