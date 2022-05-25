package com.spotify.requests.users;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.ParameterPairBuilder;
import com.spotify.requests.util.TimeRange;
import com.spotify.requests.util.Type;

/**
 * Get the current user's top artists or tracks based on calculated affinity.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-top-artists-and-tracks">Spotify Docs</a>
 */
public class UserTopItemsGet extends AbstractRequest {

    private final static String URL = "me/top/{type}";
    private final Type type;


    /**
     * @param token The token of the related spotify api session
     * @param type  the type to queries user's top items
     */
    public UserTopItemsGet(String token, Type type) {
        super(token, new ParameterPairBuilder().addKeys("limit", "offset", "time_range")
                .addClasses(int.class, int.class, TimeRange.class).build());
        this.type = type;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{type}", this.type.toString()));
    }
}
