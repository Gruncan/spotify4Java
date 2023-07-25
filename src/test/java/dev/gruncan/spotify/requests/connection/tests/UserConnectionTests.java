package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import dev.gruncan.spotify.webapi.requests.users.UserPlaylistCreatePost;
import dev.gruncan.spotify.webapi.requests.users.UserPlaylistGet;
import dev.gruncan.spotify.webapi.requests.users.UserProfileGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserConnectionTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void userPlaylistCreatePostTest() {
        SpotifyRequestVariant request = new UserPlaylistCreatePost("dj223-gb", "Test");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void userPlaylistGetTest(){
        SpotifyRequestVariant request = new UserPlaylistGet("smedjan");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

    @Test
    @Tag("NetworkTest")
    public void userProfileGetTest(){
        SpotifyRequestVariant request = new UserProfileGet("smedjan");
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }
}
