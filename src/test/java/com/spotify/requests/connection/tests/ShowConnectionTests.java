package com.spotify.requests.connection.tests;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.connection.AbstractConnectionTest;
import com.spotify.requests.shows.ShowEpisodesGet;
import com.spotify.requests.shows.ShowGet;
import com.spotify.requests.shows.ShowSeveralGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShowConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void severalShowsGetTest() {
        SpotifyRequestVariant request = new ShowSeveralGet("5CfCWKI5pZ28U0uOzXkDHe", "5as3aKmN2k11yfDDDSrvaZ");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void showEpisodesGetTest() {
        SpotifyRequestVariant request = new ShowEpisodesGet("38bS44xjbVVZ3No3ByF1dJ");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void showGetTest() {
        SpotifyRequestVariant request = new ShowGet("38bS44xjbVVZ3No3ByF1dJ");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }


}
