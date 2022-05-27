package com.spotify.requests.search;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPairBuilder;

public class SearchGet extends AbstractRequest {

    private final static String URL = "search/";


    public SearchGet() {
        super(new ParameterPairBuilder()
                .addKeys("q", "type", "include_external", "limit", "market", "offset")
                .addClasses(String.class, String.class, String.class, Integer.class, Market.class, Integer.class)
                .build());

    }

    @Override
    public JsonObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
