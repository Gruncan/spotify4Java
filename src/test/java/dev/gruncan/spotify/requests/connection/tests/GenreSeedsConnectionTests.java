package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import dev.gruncan.spotify.api.web.requests.genres.GenreAvailableGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenreSeedsConnectionTests extends AbstractConnectionTest {

    @Test
    @Tag("NetworkTest")
    public void genreAvailableGetTest() {
        SpotifyRequestVariant request = new GenreAvailableGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }


}
