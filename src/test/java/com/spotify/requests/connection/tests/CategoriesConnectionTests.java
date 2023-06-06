package com.spotify.requests.connection.tests;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.categories.CategoryGet;
import com.spotify.requests.categories.CategorySeveralGet;
import com.spotify.requests.connection.AbstractConnectionTest;
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
