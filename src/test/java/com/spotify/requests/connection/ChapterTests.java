package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.chapters.ChapterGet;
import com.spotify.requests.chapters.SeveralChaptersGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChapterTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void chapterGetTest() {
        AbstractRequest request = new ChapterGet("75anOBJoLTr5E3d0kZjbWS");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertFalse(spotifyResponse.wasSuccess()); //TODO find a chapter ID
    }

    @Test
    @Tag("NetworkTest")
    public void severalChaptersGetTest() {
        AbstractRequest request = new SeveralChaptersGet("0IsXVP0JmcB2adSE338GkK", "3ZXb8FKZGU0EHALYX6uCzU",
                "0D5wENdkdwbqlrHoaJ9g29");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }

}
