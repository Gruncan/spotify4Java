package com.spotify.objects.categories;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.wrappers.SpotifyImage;
import com.spotify.requests.categories.CategoriesGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents spotify category<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-category">SingleCategoriesGet</a>
 *
 * @see CategoriesGet
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
