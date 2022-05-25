package com.spotify.requests.users;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.ParameterPairBuilder;
import com.spotify.requests.util.Type;


/**
 * Get the current user's followed artists.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-followed">Spotify Docs</a>
 */
public class FollowedArtists extends AbstractRequest {

    private final static String URL = "me/following/";


    /**
     * @param token The token of the related spotify api session
     */
    public FollowedArtists(String token) {
        super(token, new ParameterPairBuilder().addKeys("type", "after", "limit")
                .addClasses(Type.class, String.class, int.class).build());
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL);
    }
}
