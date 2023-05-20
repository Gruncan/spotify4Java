package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.episodes.EpisodeGet;
import com.spotify.requests.episodes.SeveralEpisodesGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EpisodeTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void episodeGetTest() {
        AbstractRequest request = new EpisodeGet("512ojhOuo1ktJprKbVcKyQ");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


    @Test
    @Tag("NetworkTest")
    public void severalEpisodeGetTest() {
        AbstractRequest request = new SeveralEpisodesGet("77o6BIVlYM3msb4MMIL1jH", "0Q86acNRm6V9GYx55SXKwf");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
