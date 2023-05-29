package com.spotify.requests.connection.tests;

import com.spotify.SpotifyResponse;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.connection.AbstractConnectionTest;
import com.spotify.requests.search.SearchGet;
import com.spotify.requests.util.Type;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchConnectionTests extends AbstractConnectionTest {

    @Test
    @Tag("NetworkTest")
    public void searchGetTest() {
        SpotifyRequestVariant request = new SearchGet("remaster%20track:Doxy%20artist:Miles%20Davis", Type.ALBUM);
        SpotifyResponse spotifyResponse = super.client.executeRequest(request);
        assertTrue(spotifyResponse.wasSuccess());
    }

}
