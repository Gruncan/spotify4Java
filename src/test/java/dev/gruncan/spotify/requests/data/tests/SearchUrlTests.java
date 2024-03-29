package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import dev.gruncan.spotify.webapi.requests.search.SearchGet;
import dev.gruncan.spotify.webapi.requests.util.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchUrlTests extends AbstractUrlTest {

    @Test
    public void searchGetTestUrl() {
        SpotifyRequestVariant request = new SearchGet("remaster%20track:Doxy%20artist:Miles%20Davis", Type.ALBUM);
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
