package com.spotify.requests.data.tests;

import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.data.AbstractUrlTest;
import com.spotify.requests.episodes.EpisodeGet;
import com.spotify.requests.episodes.EpisodeSeveralGet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EpisodeUrlTests extends AbstractUrlTest {


    @Test
    public void episodeGetTestUrl() {
        SpotifyRequestVariant request = new EpisodeGet("512ojhOuo1ktJprKbVcKyQ");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }


    @Test
    public void episodeSeveralGetTestUrl() {
        SpotifyRequestVariant request = new EpisodeSeveralGet("77o6BIVlYM3msb4MMIL1jH", "0Q86acNRm6V9GYx55SXKwf");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
