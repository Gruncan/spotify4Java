package com.spotify.requests.users;

import com.spotify.json.JSONObject;
import com.spotify.objects.user.SpotifyUser;
import com.spotify.requests.AbstractRequest;


/**
 * Get detailed profile information about the current user (including the current user's username).
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-current-users-profile">Spotify Docs</a>
 */
public class CurrentUserProfileGet extends AbstractRequest<SpotifyUser> {


    private final static String URL = "me/";

    /**
     * @param token The token of the related spotify api session
     */
    public CurrentUserProfileGet() {
        super();
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL);
    }


}
