package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.albums.AlbumGet;
import dev.gruncan.spotify.api.web.requests.albums.AlbumSeveralGet;
import dev.gruncan.spotify.api.web.requests.albums.AlbumTracksGet;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlbumConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void albumGetTest() {
        SpotifyRequestVariant request = new AlbumGet("4aawyAB9vmqN3uQ7FjRGTy");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


    @Test
    @Tag("NetworkTest")
    public void severalAlbumGetTest() {
        SpotifyRequestVariant request = new AlbumSeveralGet("382ObEPsp2rxGrnsizN5TX", "1A2GTWGtFfWp7KSQTwWOyo", "2noRn2Aes5aoNVsU6iWThc");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void albumTracksGetTest() {
        SpotifyRequestVariant request = new AlbumTracksGet("4aawyAB9vmqN3uQ7FjRGTy");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
