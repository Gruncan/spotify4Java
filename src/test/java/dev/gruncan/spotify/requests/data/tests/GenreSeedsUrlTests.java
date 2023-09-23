package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import dev.gruncan.spotify.api.web.requests.genres.GenreAvailableGet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenreSeedsUrlTests extends AbstractUrlTest {

    @Test
    public void genreAvailableGetTestUrl() {
        SpotifyRequestVariant request = new GenreAvailableGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));

    }


}
