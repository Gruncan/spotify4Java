package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.genres.GenreAvailableGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenreTests extends AbstractConnectionTest {

    @Test
    @Tag("NetworkTest")
    public void genreAvailableGetTest() {
        AbstractRequest request = new GenreAvailableGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }


}