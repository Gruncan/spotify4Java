package dev.gruncan.spotify.requests.data.tests;

import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.categories.CategoryGet;
import dev.gruncan.spotify.webapi.requests.categories.CategorySeveralGet;
import dev.gruncan.spotify.requests.data.AbstractUrlTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriesUrlTests extends AbstractUrlTest {


    @Test
    public void categoryGetTestUrl() {
        SpotifyRequestVariant request = new CategorySeveralGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void categorySeveralGetTestUrl() {
        SpotifyRequestVariant request = new CategoryGet("dinner");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
