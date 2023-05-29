package com.spotify.requests.data.tests;

import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.categories.SeveralCategoriesGet;
import com.spotify.requests.categories.SingleCategoriesGet;
import com.spotify.requests.data.AbstractUrlTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriesUrlTests extends AbstractUrlTest {


    @Test
    public void severalCategoriesGetTestUrl() {
        SpotifyRequestVariant request = new SeveralCategoriesGet();
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

    @Test
    public void singleCategoriesGetTestUrl() {
        SpotifyRequestVariant request = new SingleCategoriesGet("dinner");
        String actualUrl = super.client.getBuiltURL(request);
        assertEquals(actualUrl, super.getCorrectURL(request.getClass()));
    }

}
