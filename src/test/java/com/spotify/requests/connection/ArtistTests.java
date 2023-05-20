package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.artists.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArtistTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void artistGetTest() {
        AbstractRequest request = new ArtistGet("0TnOYISbd1XYRBk9myaseg");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void artistsAlbumsGetTest() {
        AbstractRequest request = new ArtistsAlbumsGet("0TnOYISbd1XYRBk9myaseg");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void artistsRelatedArtistsGetTest() {
        AbstractRequest request = new ArtistsRelatedArtistsGet("0TnOYISbd1XYRBk9myaseg");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void artistsTopTracksGetTest() {
        AbstractRequest request = new ArtistsTopTracksGet("0TnOYISbd1XYRBk9myaseg", Country.GB);
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void severalArtistsTest() {
        AbstractRequest request = new SeveralArtistsGet("2CIMQHirSU0MQqyYHq0eOx", "57dN52uHvrHOxijzpIgu3E"
                , "1vCWHaC5f2uS3yhpwWbIA6");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
