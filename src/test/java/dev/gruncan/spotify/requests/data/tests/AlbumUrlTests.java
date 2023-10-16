package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.albums.AlbumGet;
import dev.gruncan.spotify.api.web.requests.albums.AlbumReleasesGet;
import dev.gruncan.spotify.api.web.requests.albums.AlbumSeveralGet;
import dev.gruncan.spotify.api.web.requests.albums.AlbumTracksGet;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
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
    public void albumReleasesGetTestUrl(){
        SpotifyRequestVariant request = new AlbumReleasesGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void albumSeveralGetTestUrl() {
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
