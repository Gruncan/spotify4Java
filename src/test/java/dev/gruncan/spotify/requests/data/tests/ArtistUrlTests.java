package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.objects.wrappers.Country;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import dev.gruncan.spotify.webapi.requests.artists.*;
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
    public void artistSeveralGetTestUrl() {
        SpotifyRequestVariant request = new ArtistSeveralGet("2CIMQHirSU0MQqyYHq0eOx", "57dN52uHvrHOxijzpIgu3E"
                , "1vCWHaC5f2uS3yhpwWbIA6");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
