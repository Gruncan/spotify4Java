package com.spotify.requests.search;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.util.Market;


@SpotifyRequest("search")
public class SearchGet extends AbstractRequest {

    @SpotifyRequestField
    private final String q;

    @SpotifyRequestField
    private final String type;

    @SpotifyRequestField
    private String include_external;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private Market market;

    @SpotifyRequestField
    private int offset;

    public SearchGet(String q, String type) {
        this.q = q;
        this.type = type;
        this.include_external = null;
        this.limit = -1;
        this.market = null;
        this.offset = -1;
    }


    public void setIncludeExternal(String s) {
        this.include_external = s;
    }

    public void setLimit(int limit) {
        this.limit = Math.max(0, Math.min(limit, 50));
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public void setOffset(int offset) {
        this.offset = Math.max(0, Math.min(offset, 1000));
    }


}
