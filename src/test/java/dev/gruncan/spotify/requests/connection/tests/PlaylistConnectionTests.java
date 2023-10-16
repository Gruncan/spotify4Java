package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import dev.gruncan.spotify.api.web.requests.playlists.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void categoriesPlaylistsGetTest() {
        SpotifyRequestVariant request = new PlaylistCategoriesGet("dinner");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void featuredPlaylistsGetTest() {
        SpotifyRequestVariant request = new PlaylistFeaturedGet();
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
