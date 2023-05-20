package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.audiobooks.AudiobookChaptersGet;
import com.spotify.requests.audiobooks.AudiobookGet;
import com.spotify.requests.audiobooks.SeveralAudioBooksGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AudiobookTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void audiobookChaptersGetTest() {
        AbstractRequest request = new AudiobookChaptersGet("7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void audiobookGetTest() {
        AbstractRequest request = new AudiobookGet("7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void severalAudiobooksGetTest() {
        AbstractRequest request = new SeveralAudioBooksGet("18yVqkdbdRvS24c0Ilj2ci", "1HGw3J3NxZO1TP1BTtVhpZ", "7iHfbu1YPACw6oZPAFJtqe");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


}
