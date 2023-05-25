package com.spotify.requests.connection.tests;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.connection.AbstractConnectionTest;
import com.spotify.requests.playlists.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void categoriesPlaylistsGetTest() {
        SpotifyRequestVariant request = new CategoriesPlaylistsGet("dinner");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void featuredPlaylistsGetTest() {
        SpotifyRequestVariant request = new FeaturedPlaylistGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }

    @Test
    @Tag("NetworkTest")
    public void playlistsGetTest() {
        SpotifyRequestVariant request = new PlaylistGet("3cEYpjA9oz9GiPac4AsH4n");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }

    @Test
    @Tag("NetworkTest")
    public void playlistImageGetTest() {
        SpotifyRequestVariant request = new PlaylistImageGet("3cEYpjA9oz9GiPac4AsH4n");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }

    @Test
    @Tag("NetworkTest")
    public void playlistTracksGetTest() {
        SpotifyRequestVariant request = new PlaylistTracksGet("3cEYpjA9oz9GiPac4AsH4n");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }
}
