package com.spotify.requests.categories;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest("browse/categories")
public class SingleCategoriesGet extends AbstractRequest {


    @SpotifySubRequest
    private final String category_id;

    @SpotifyRequestField
    private Market country;

    @SpotifyRequestField
    private String locale;

    public SingleCategoriesGet(String category_id) {
        this.category_id = category_id;
    }


}
