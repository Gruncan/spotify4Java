package com.spotify.requests.categories;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.categories.Categories;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

@Setter
@SpotifyRequest("browse/categories")
@SpotifySerialize(Categories.class)
public class SeveralCategoriesGet extends AbstractRequest {


    @SpotifyRequestField
    private Country country;

    @SpotifyRequestField
    private String locale;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

}
