package dev.gruncan.spotify.requests.connection.tests;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.connection.AbstractConnectionTest;
import dev.gruncan.spotify.api.web.requests.search.SearchGet;
import dev.gruncan.spotify.api.web.requests.util.Type;
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
