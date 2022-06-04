package com.spotify.requests.search;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPairBuilder;

public class SearchGet extends AbstractRequest {

    private final static String URL = "search/";


    public SearchGet(String q, String type) {
        super(new ParameterPairBuilder()
                .addKeys("q", "type", "include_external", "limit", "market", "offset")
                .addClasses(String.class, String.class, String.class, Integer.class, Market.class, Integer.class)
                .build());
        super.addQuery(new RequestQuery<>("q", q));
        super.addQuery(new RequestQuery<>("type", type));

    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
