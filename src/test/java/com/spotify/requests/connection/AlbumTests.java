package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.albums.AlbumGet;
import com.spotify.requests.albums.AlbumTracksGet;
import com.spotify.requests.albums.SeveralAlbumsGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlbumTests extends AbstractConnectionTest {


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
        SpotifyRequestVariant request = new SeveralAlbumsGet("382ObEPsp2rxGrnsizN5TX", "1A2GTWGtFfWp7KSQTwWOyo", "2noRn2Aes5aoNVsU6iWThc");
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
