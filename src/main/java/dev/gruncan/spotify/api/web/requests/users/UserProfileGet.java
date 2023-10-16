package dev.gruncan.spotify.api.web.requests.users;


import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.user.SimplifiedUser;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;

/**
 * Get public profile information about a Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-profile">Spotify Docs</a>
 * <p>Serializes into {@link SimplifiedUser}</p>
 *
 * @see SimplifiedUser
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest("users")
@SpotifySerialize(SimplifiedUser.class)
public class UserProfileGet implements SpotifyRequestVariant {

    /**
     * The user's Spotify user ID.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * Initializes the {@link UserProfileGet} request
     * @param id The Spotify ID of the user.
     */
    public UserProfileGet(String id) {
        this.id = id;
    }

}
