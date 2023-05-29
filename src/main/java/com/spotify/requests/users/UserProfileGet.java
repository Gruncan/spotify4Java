package com.spotify.requests.users;


import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.user.Profile;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;

@SpotifyRequest("me")
@SpotifySerialize(Profile.class)
public class UserProfileGet implements SpotifyRequestVariant {


}
