package com.spotify.requests.connection.tests;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.connection.AbstractConnectionTest;
import com.spotify.requests.episodes.EpisodeGet;
import com.spotify.requests.episodes.SeveralEpisodesGet;
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
        SpotifyRequestVariant request = new SeveralEpisodesGet("77o6BIVlYM3msb4MMIL1jH", "0Q86acNRm6V9GYx55SXKwf");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
