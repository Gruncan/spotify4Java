package com.spotify.requests.users;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.RequestQuery;
import com.spotify.requests.util.ParameterPairBuilder;
import com.spotify.util.Util;

/**
 * Check to see if the current user is following one or more artists or other Spotify users.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/check-current-user-follows">Spotify Docs</a>
 */
public class UserCheckFollowsArtistUser extends AbstractRequest {

    private final static String URL = "me/following/contains";

    /**
     * @param ids The array of id of the artist or users to be queried
     */
    public UserCheckFollowsArtistUser(String... ids) {
        super(new ParameterPairBuilder().addKeys("ids", "type")
                .addClasses(String.class, String.class).build());
        super.addQuery(new RequestQuery<>("ids", Util.join(ids, ",")));
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL);
    }
}
