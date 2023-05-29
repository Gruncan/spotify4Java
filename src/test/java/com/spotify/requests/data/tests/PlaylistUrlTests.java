package com.spotify.requests.data.tests;

import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.data.AbstractUrlTest;
import com.spotify.requests.playlists.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistUrlTests extends AbstractUrlTest {


    @Test
    public void categoriesPlaylistsGetTestUrl() {
        SpotifyRequestVariant request = new CategoriesPlaylistsGet("dinner");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void featuredPlaylistsGetTestUrl() {
        SpotifyRequestVariant request = new FeaturedPlaylistGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));

    }

    @Test
    public void playlistsGetTestUrl() {
        SpotifyRequestVariant request = new PlaylistGet("3cEYpjA9oz9GiPac4AsH4n");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));

    }

    @Test
    public void playlistImageGetTestUrl() {
        SpotifyRequestVariant request = new PlaylistImageGet("3cEYpjA9oz9GiPac4AsH4n");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));

    }

    @Test
    public void playlistTracksGetTestUrl() {
        SpotifyRequestVariant request = new PlaylistTracksGet("3cEYpjA9oz9GiPac4AsH4n");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));

    }
}
