package com.spotify.requests.data.tests;

import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.chapters.ChapterGet;
import com.spotify.requests.chapters.ChapterSeveralGet;
import com.spotify.requests.data.AbstractUrlTest;
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
    public void severalChaptersGetTestUrl() {
        SpotifyRequestVariant request = new ChapterSeveralGet("0IsXVP0JmcB2adSE338GkK", "3ZXb8FKZGU0EHALYX6uCzU",
                "0D5wENdkdwbqlrHoaJ9g29");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));

    }

}
