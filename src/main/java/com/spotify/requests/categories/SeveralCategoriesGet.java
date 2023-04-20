package com.spotify.requests.categories;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

@Setter
@SpotifyRequest("browse/categories")
public class SeveralCategoriesGet extends AbstractRequest {


    @SpotifyRequestField
    private Market country;

    @SpotifyRequestField
    private String locale;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

}
