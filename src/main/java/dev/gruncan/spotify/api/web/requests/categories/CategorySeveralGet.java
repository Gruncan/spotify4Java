package dev.gruncan.spotify.api.web.requests.categories;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.categories.Categories;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import lombok.Setter;

/**
 * Get a list of categories used to tag items in Spotify (on, for example, the Spotify player's "Browse" tab).
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-categories">Spotify Docs</a>
 * <p>Serializes into {@link Categories} array</p>
 *
 * @see Categories
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("browse/categories")
@SpotifySerialize(Categories.class)
public class CategorySeveralGet implements SpotifyRequestVariant {


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
