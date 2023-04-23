package com.spotify.requests.categories;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.categories.Categories;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

/**
 * Get a list of categories used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-categories">Spotify Docs</a>
 * <p>Serializes into {@link Categories}</p>
 *
 * @see Categories
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("browse/categories")
@SpotifySerialize(Categories.class)
public class SeveralCategoriesGet extends AbstractRequest {


    /**
     * A country: an ISO 3166-1 alpha-2 country code. Provide this parameter if you want to narrow the list of returned
     * categories to those relevant to a particular country. If omitted, the returned items will be globally relevant.
     */
    @SpotifyRequestField
    private Country country;

    /**
     * The desired language, consisting of an ISO 639-1 language code and an ISO 3166-1 alpha-2 country code, joined by an underscore.
     */
    @SpotifyRequestField
    private String locale;

    /**
     * The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @SpotifyRequestField
    private int offset;

}
