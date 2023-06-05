package com.spotify.requests.me;


import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.user.Profile;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

@SpotifyRequest(value = "me", authorizations = {Scope.USER_READ_PRIVATE, Scope.USER_READ_EMAIL})
@SpotifySerialize(Profile.class)
public class MyProfileGet implements SpotifyRequestVariant {


}
