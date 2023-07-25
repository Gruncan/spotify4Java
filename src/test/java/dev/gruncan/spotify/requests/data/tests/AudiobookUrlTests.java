package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.audiobooks.AudiobookChaptersGet;
import dev.gruncan.spotify.webapi.requests.audiobooks.AudiobookGet;
import dev.gruncan.spotify.webapi.requests.audiobooks.AudiobookSeveralGet;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudiobookUrlTests extends AbstractUrlTest {


    @Test
    public void audiobookChaptersGetTestUrl() {
        SpotifyRequestVariant request = new AudiobookChaptersGet("7iHfbu1YPACw6oZPAFJtqe");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void audiobookGetTestUrl() {
        SpotifyRequestVariant request = new AudiobookGet("7iHfbu1YPACw6oZPAFJtqe");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void audiobookSeveralGetTestUrl() {
        SpotifyRequestVariant request = new AudiobookSeveralGet("18yVqkdbdRvS24c0Ilj2ci", "1HGw3J3NxZO1TP1BTtVhpZ", "7iHfbu1YPACw6oZPAFJtqe");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }


}
