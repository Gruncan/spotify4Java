package com.spotify.requests.connection;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.markets.MarketsAvailableGet;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarketTests extends AbstractConnectionTest {


    @Test
    @Tag("NetworkTest")
    public void marketAvailableGetTest() {
        SpotifyRequestVariant request = new MarketsAvailableGet();
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
