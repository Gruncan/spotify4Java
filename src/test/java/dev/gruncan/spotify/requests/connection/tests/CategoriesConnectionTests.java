package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.categories.CategoryGet;
import dev.gruncan.spotify.api.web.requests.categories.CategorySeveralGet;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoriesConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void severalCategoriesGetTest() {
        SpotifyRequestVariant request = new CategorySeveralGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void singleCategoriesGetTest() {
        SpotifyRequestVariant request = new CategoryGet("dinner");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
