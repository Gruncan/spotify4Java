package com.spotify.requests.search;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.search.Search;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.util.Type;
import lombok.Setter;


@SpotifyRequest("search")
@SpotifySerialize(Search.class)
@Setter
public class SearchGet extends AbstractRequest {

    @SpotifyRequestField
    private final String q;

    @SpotifyRequestField
    private final Type[] type;

    @SpotifyRequestField
    private Country market;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;

    @SpotifyRequestField("include_external")
    private String includeExternal;

    public SearchGet(String q, Type... type) {
        this.q = q;
        this.type = type;
        this.includeExternal = null;
        this.limit = -1;
        this.market = null;
        this.offset = -1;
    }

}
