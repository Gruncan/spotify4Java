package com.spotify.requests.users;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;

public class CurrentUserProfileGet extends AbstractRequest {


    private final static String url = "me/";


    public CurrentUserProfileGet(String token) {
        super(token);
    }

    @Override
    public JsonObject execute() {
        JsonObject jsonObject = super.requestGet(url);
        return jsonObject;
    }
}
