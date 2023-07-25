package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.chapters.ChapterGet;
import dev.gruncan.spotify.webapi.requests.chapters.ChapterSeveralGet;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChapterUrlTests extends AbstractUrlTest {


    @Test
    public void chapterGetTestUrl() {
        SpotifyRequestVariant request = new ChapterGet("0D5wENdkdwbqlrHoaJ9g29");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void chapterSeveralGetTestUrl() {
        SpotifyRequestVariant request = new ChapterSeveralGet("0IsXVP0JmcB2adSE338GkK", "3ZXb8FKZGU0EHALYX6uCzU",
                "0D5wENdkdwbqlrHoaJ9g29");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));

    }

}
