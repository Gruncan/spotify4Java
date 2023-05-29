package com.spotify.requests.categories;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.categories.Category;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get a single category used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-category">Spotify Docs</a>
 * <p>Serializes into {@link Category}</p>
 *
 * @see Category
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("browse/categories")
@SpotifySerialize(Category.class)
public class SingleCategoriesGet implements SpotifyRequestVariant {


    /**
     * The Spotify category ID for the category.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * A country: an ISO 3166-1 alpha-2 country code. Provide this parameter to ensure that the category exists for a particular country.
     */
    @SpotifyRequestField
    private Country country;

    /**
     * The desired language, consisting of an ISO 639-1 language code and an ISO 3166-1 alpha-2 country code, joined by an underscore.
     */
    @SpotifyRequestField
    private String locale;

    /**
     * Initializes the {@link SingleCategoriesGet} request
     * @param id The Spotify category ID for the category.
     */
    public SingleCategoriesGet(String id) {
        this.id = id;
    }


}
