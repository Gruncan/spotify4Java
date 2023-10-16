package dev.gruncan.spotify.api.web.requests.me;


import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.user.Profile;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;

/**
 * Get detailed profile information about the current user (including the current user's username).
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-current-users-profile">Spotify Docs</a>
 * <p>Serializes into {@link Profile}</p>
 *
 * @see Profile
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "me", authorizations = {Scope.USER_READ_PRIVATE, Scope.USER_READ_EMAIL})
@SpotifySerialize(Profile.class)
public class MyProfileGet implements SpotifyRequestVariant {


}
