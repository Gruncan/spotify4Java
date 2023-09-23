package dev.gruncan.spotify.api.web.objects.categories;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.objects.wrappers.SpotifyImage;
import dev.gruncan.spotify.api.web.requests.categories.CategoryGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents spotify category<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-category">SingleCategoriesGet</a>
 *
 * @see CategoryGet
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
@Setter
public class Category implements SpotifyObject {

    /**
     * A link to the Web API endpoint returning full details of the category.
     */
    @SpotifyField
    private String href;

    /**
     * The category icon, in various sizes.
     */
    @SpotifyField
    private SpotifyImage[] icons;

    /**
     * The Spotify category ID of the category.
     */
    @SpotifyField
    private String id;

    /**
     * The name of the category.
     */
    @SpotifyField
    private String name;


}
