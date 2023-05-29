package com.spotify.requests.connection.tests;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.audiobooks.AudiobookChaptersGet;
import com.spotify.requests.audiobooks.AudiobookGet;
import com.spotify.requests.audiobooks.SeveralAudioBooksGet;
import com.spotify.requests.connection.AbstractConnectionTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AudiobookConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void audiobookChaptersGetTest() {
        SpotifyRequestVariant request = new AudiobookChaptersGet("7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void audiobookGetTest() {
        SpotifyRequestVariant request = new AudiobookGet("7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void severalAudiobooksGetTest() {
        SpotifyRequestVariant request = new SeveralAudioBooksGet("18yVqkdbdRvS24c0Ilj2ci", "1HGw3J3NxZO1TP1BTtVhpZ", "7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


}
