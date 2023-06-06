package com.spotify.requests.me;


import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.user.Profile;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;

/**
 * Get detailed profile information about the current user (including the current user's username).
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-current-users-profile">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me", authorizations = {Scope.USER_READ_PRIVATE, Scope.USER_READ_EMAIL})
@SpotifySerialize(Profile.class)
public class MyProfileGet implements SpotifyRequestVariant {


}
