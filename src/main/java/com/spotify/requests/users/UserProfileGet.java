package com.spotify.requests.users;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;


/**
 * Get public profile information about a Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-profile">Spotify Docs</a>
 */
public class UserProfileGet extends AbstractRequest {

    private final static String URL = "users/{user_id}";
    private final String user_id;

    /**
     * @param token   The token of the related spotify api session
     * @param user_id The id of the user to be queried
     */
    public UserProfileGet(String token, String user_id) {
        super(token);
        this.user_id = user_id;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{user_id}", this.user_id));
    }
}
