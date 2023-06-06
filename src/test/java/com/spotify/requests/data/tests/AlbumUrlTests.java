package com.spotify.requests.data.tests;

import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.albums.AlbumGet;
import com.spotify.requests.albums.AlbumSeveralGet;
import com.spotify.requests.albums.AlbumTracksGet;
import com.spotify.requests.data.AbstractUrlTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumUrlTests extends AbstractUrlTest {


    @Test
    public void albumGetTestUrl() {
        SpotifyRequestVariant request = new AlbumGet("4aawyAB9vmqN3uQ7FjRGTy");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));

    }


    @Test
    public void severalAlbumGetTestUrl() {
        SpotifyRequestVariant request = new AlbumSeveralGet("382ObEPsp2rxGrnsizN5TX", "1A2GTWGtFfWp7KSQTwWOyo", "2noRn2Aes5aoNVsU6iWThc");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void albumTracksGetTestUrl() {
        SpotifyRequestVariant request = new AlbumTracksGet("4aawyAB9vmqN3uQ7FjRGTy");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
