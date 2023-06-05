package com.spotify.requests.users;


import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;

@SpotifyRequest("users")
public class UserProfileGet implements SpotifyRequestVariant {

    @SpotifySubRequest
    private final String id;


    public UserProfileGet(String id) {
        this.id = id;
    }

}
