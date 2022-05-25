package com.spotify.requests.users;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;


/**
 * Get detailed profile information about the current user (including the current user's username).
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-current-users-profile">Spotify Docs</a>
 */
public class CurrentUserProfileGet extends AbstractRequest {


    private final static String url = "me/";

    /**
     * @param token The token of the related spotify api session
     */
    public CurrentUserProfileGet(String token) {
        super(token);
    }

    @Override
    public JsonObject execute() {
        JsonObject jsonObject = super.requestGet(url);
        return jsonObject;
    }
}
