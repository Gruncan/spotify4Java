package dev.gruncan.spotify.webapi.requests.categories;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.categories.Category;
import dev.gruncan.spotify.webapi.objects.wrappers.Country;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get a single category used to tag items in Spotify (on, for example, the Spotify player's "Browse" tab).
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
public class CategoryGet implements SpotifyRequestVariant {


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
     * Initializes the {@link CategoryGet} request
     * @param id The Spotify category ID for the category.
     */
    public CategoryGet(String id) {
        this.id = id;
    }


}
