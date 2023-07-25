package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.chapters.ChapterGet;
import dev.gruncan.spotify.webapi.requests.chapters.ChapterSeveralGet;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChapterConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void chapterGetTest() {
        SpotifyRequestVariant request = new ChapterGet("0D5wENdkdwbqlrHoaJ9g29");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertFalse(spotifyResponse.wasSuccess()); //TODO find a chapter ID
    }

    @Test
    @Tag("NetworkTest")
    public void severalChaptersGetTest() {
        SpotifyRequestVariant request = new ChapterSeveralGet("0IsXVP0JmcB2adSE338GkK", "3ZXb8FKZGU0EHALYX6uCzU",
                "0D5wENdkdwbqlrHoaJ9g29");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }

}
