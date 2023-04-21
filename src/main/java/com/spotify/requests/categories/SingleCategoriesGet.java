package com.spotify.requests.categories;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.categories.Category;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest("browse/categories")
@SpotifySerialize(Category.class)
public class SingleCategoriesGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Country country;

    @SpotifyRequestField
    private String locale;

    public SingleCategoriesGet(String id) {
        this.id = id;
    }


}
