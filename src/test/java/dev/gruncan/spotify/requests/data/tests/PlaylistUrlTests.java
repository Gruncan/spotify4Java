package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import dev.gruncan.spotify.webapi.requests.playlists.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistUrlTests extends AbstractUrlTest {



    @Test
    public void playlistAddCoverImagePutTestUrl(){
        SpotifyRequestVariant request = new PlaylistAddCoverImagePut("3cEYpjA9oz9GiPac4AsH4n", "C:\\Users\\DJ223\\Pictures\\test.jpeg");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void playlistAddItemPostTestUrl(){
        SpotifyRequestVariant request = new PlaylistAddItemPost("3cEYpjA9oz9GiPac4AsH4n");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }


    @Test
    public void playlistCategoriesGetTestUrl() {
        SpotifyRequestVariant request = new PlaylistCategoriesGet("dinner");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void playlistChangeDetailsPutTestUrl() {
        SpotifyRequestVariant request = new PlaylistChangeDetailsPut("3cEYpjA9oz9GiPac4AsH4n");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void playlistFeaturedGetTestUrl() {
        SpotifyRequestVariant request = new PlaylistFeaturedGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void playlistFollowingCheckGetTestUrl() {
        SpotifyRequestVariant request = new PlaylistFollowingCheckGet("4aawyAB9vmqN3uQ7FjRGTy", "jmperezperez,thelinmichael,wizzler");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void playlistFollowPutTestUrl() {
        SpotifyRequestVariant request = new PlaylistFollowPut("3cEYpjA9oz9GiPac4AsH4n", false);
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
    public void playlistRemoveItemDeleteTestUrl() {
        SpotifyRequestVariant request = new PlaylistRemoveItemDelete("3cEYpjA9oz9GiPac4AsH4n", "spotify:track:4iV5W9uYEdYUVa79Axb7Rh");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void playlistTracksGetTestUrl() {
        SpotifyRequestVariant request = new PlaylistTracksGet("3cEYpjA9oz9GiPac4AsH4n");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void playlistUnfollowDeleteTestUrl() {
        SpotifyRequestVariant request = new PlaylistUnfollowDelete("3cEYpjA9oz9GiPac4AsH4n");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void playlistUpdatePutTestUrl() {
        SpotifyRequestVariant request = new PlaylistUpdatePut("3cEYpjA9oz9GiPac4AsH4n");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }
}
