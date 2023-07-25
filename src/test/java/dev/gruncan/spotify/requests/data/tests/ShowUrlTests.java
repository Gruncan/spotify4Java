package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import dev.gruncan.spotify.webapi.requests.shows.ShowEpisodesGet;
import dev.gruncan.spotify.webapi.requests.shows.ShowGet;
import dev.gruncan.spotify.webapi.requests.shows.ShowSeveralGet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowUrlTests extends AbstractUrlTest {


    @Test
    public void showSeveralGetTestUrl() {
        SpotifyRequestVariant request = new ShowSeveralGet("5CfCWKI5pZ28U0uOzXkDHe", "5as3aKmN2k11yfDDDSrvaZ");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void showEpisodesGetTestUrl() {
        SpotifyRequestVariant request = new ShowEpisodesGet("38bS44xjbVVZ3No3ByF1dJ");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void showGetTestUrl() {
        SpotifyRequestVariant request = new ShowGet("38bS44xjbVVZ3No3ByF1dJ");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }


}
