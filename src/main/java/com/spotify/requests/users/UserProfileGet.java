package com.spotify.requests.users;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;


/**
 * Get public profile information about a Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-profile">Spotify Docs</a>
 */
public class UserProfileGet extends AbstractRequest {

    private final static String URL = "users/{user_id}";
    private final String userID;

    /**
     * @param token  The token of the related spotify api session
     * @param userId The id of the user to be queried
     */
    public UserProfileGet(String userId) {
        super();
        this.userID = userId;
    }

    @Override
    public JsonObject execute(String token) {
        return super.requestGet(token, URL.replace("{user_id}", this.userID));
    }
}
