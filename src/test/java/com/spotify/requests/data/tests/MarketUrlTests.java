package com.spotify.requests.data.tests;

import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.data.AbstractUrlTest;
import com.spotify.requests.markets.MarketsAvailableGet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketUrlTests extends AbstractUrlTest {


    @Test
    public void marketAvailableGetTestUrl() {
        SpotifyRequestVariant request = new MarketsAvailableGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
