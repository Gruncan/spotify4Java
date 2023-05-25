package com.spotify.requests.connection.tests;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.connection.AbstractConnectionTest;
import com.spotify.requests.genres.GenreAvailableGet;
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
