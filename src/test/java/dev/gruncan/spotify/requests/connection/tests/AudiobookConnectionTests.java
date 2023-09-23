package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.audiobooks.AudiobookChaptersGet;
import dev.gruncan.spotify.api.web.requests.audiobooks.AudiobookGet;
import dev.gruncan.spotify.api.web.requests.audiobooks.AudiobookSeveralGet;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
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
        SpotifyRequestVariant request = new AudiobookSeveralGet("18yVqkdbdRvS24c0Ilj2ci", "1HGw3J3NxZO1TP1BTtVhpZ", "7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


}
