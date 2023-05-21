package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.categories.SeveralCategoriesGet;
import com.spotify.requests.categories.SingleCategoriesGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoriesTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void severalCategoriesGetTest() {
        SpotifyRequestVariant request = new SeveralCategoriesGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void singleCategoriesGetTest() {
        SpotifyRequestVariant request = new SingleCategoriesGet("dinner");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
