package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import dev.gruncan.spotify.api.web.requests.markets.MarketsAvailableGet;
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
