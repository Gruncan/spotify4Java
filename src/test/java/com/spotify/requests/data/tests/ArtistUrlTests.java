package com.spotify.requests.data.tests;

import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.artists.*;
import com.spotify.requests.data.AbstractUrlTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtistUrlTests extends AbstractUrlTest {


    @Test
    public void artistGetTestUrl() {
        SpotifyRequestVariant request = new ArtistGet("0TnOYISbd1XYRBk9myaseg");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void artistsAlbumsGetTestUrl() {
        SpotifyRequestVariant request = new ArtistsAlbumsGet("0TnOYISbd1XYRBk9myaseg");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void artistsRelatedArtistsGetTestUrl() {
        SpotifyRequestVariant request = new ArtistsRelatedArtistsGet("0TnOYISbd1XYRBk9myaseg");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void artistsTopTracksGetTestUrl() {
        SpotifyRequestVariant request = new ArtistsTopTracksGet("0TnOYISbd1XYRBk9myaseg", Country.ES);
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void severalArtistsTestUrl() {
        SpotifyRequestVariant request = new ArtistSeveralGet("2CIMQHirSU0MQqyYHq0eOx", "57dN52uHvrHOxijzpIgu3E"
                , "1vCWHaC5f2uS3yhpwWbIA6");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
