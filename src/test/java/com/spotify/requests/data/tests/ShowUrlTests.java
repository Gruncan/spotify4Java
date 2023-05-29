package com.spotify.requests.data.tests;

import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.data.AbstractUrlTest;
import com.spotify.requests.shows.SeveralShowsGet;
import com.spotify.requests.shows.ShowEpisodesGet;
import com.spotify.requests.shows.ShowGet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowUrlTests extends AbstractUrlTest {


    @Test
    public void severalShowsGetTestUrl() {
        SpotifyRequestVariant request = new SeveralShowsGet("5CfCWKI5pZ28U0uOzXkDHe", "5as3aKmN2k11yfDDDSrvaZ");
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
