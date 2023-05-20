package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.playlists.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaylistTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void categoriesPlaylistsGetTest() {
        AbstractRequest request = new CategoriesPlaylistsGet("dinner");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void featuredPlaylistsGetTest() {
        AbstractRequest request = new FeaturedPlaylistGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }

    @Test
    @Tag("NetworkTest")
    public void playlistsGetTest() {
        AbstractRequest request = new PlaylistGet("3cEYpjA9oz9GiPac4AsH4n");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }

    @Test
    @Tag("NetworkTest")
    public void playlistImageGetTest() {
        AbstractRequest request = new PlaylistImageGet("3cEYpjA9oz9GiPac4AsH4n");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }

    @Test
    @Tag("NetworkTest")
    public void playlistTracksGetTest() {
        AbstractRequest request = new PlaylistTracksGet("3cEYpjA9oz9GiPac4AsH4n");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());

    }
}
