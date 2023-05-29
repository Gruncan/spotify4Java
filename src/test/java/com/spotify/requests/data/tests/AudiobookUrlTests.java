package com.spotify.requests.data.tests;

import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.audiobooks.AudiobookChaptersGet;
import com.spotify.requests.audiobooks.AudiobookGet;
import com.spotify.requests.audiobooks.SeveralAudioBooksGet;
import com.spotify.requests.data.AbstractUrlTest;
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
    public void severalAudiobooksGetTestUrl() {
        SpotifyRequestVariant request = new SeveralAudioBooksGet("18yVqkdbdRvS24c0Ilj2ci", "1HGw3J3NxZO1TP1BTtVhpZ", "7iHfbu1YPACw6oZPAFJtqe");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }


}
