package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.objects.wrappers.Country;
import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.artists.*;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArtistConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void artistGetTest() {
        SpotifyRequestVariant request = new ArtistGet("0TnOYISbd1XYRBk9myaseg");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void artistsAlbumsGetTest() {
        SpotifyRequestVariant request = new ArtistsAlbumsGet("0TnOYISbd1XYRBk9myaseg");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void artistsRelatedArtistsGetTest() {
        SpotifyRequestVariant request = new ArtistsRelatedArtistsGet("0TnOYISbd1XYRBk9myaseg");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void artistsTopTracksGetTest() {
        SpotifyRequestVariant request = new ArtistsTopTracksGet("0TnOYISbd1XYRBk9myaseg", Country.ES);
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void severalArtistsTest() {
        SpotifyRequestVariant request = new ArtistSeveralGet("2CIMQHirSU0MQqyYHq0eOx", "57dN52uHvrHOxijzpIgu3E"
                , "1vCWHaC5f2uS3yhpwWbIA6");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
