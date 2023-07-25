package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import dev.gruncan.spotify.webapi.requests.users.UserPlaylistCreatePost;
import dev.gruncan.spotify.webapi.requests.users.UserPlaylistGet;
import dev.gruncan.spotify.webapi.requests.users.UserProfileGet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserUrlTest extends AbstractUrlTest {

    @Test
    public void userPlaylistCreatePostTestUrl() {
        SpotifyRequestVariant request = new UserPlaylistCreatePost("smedjan", "Test");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void userPlaylistGetTestUrl() {
        SpotifyRequestVariant request = new UserPlaylistGet("smedjan");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void userProfileGetTestUrl() {
        SpotifyRequestVariant request = new UserProfileGet("smedjan");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
