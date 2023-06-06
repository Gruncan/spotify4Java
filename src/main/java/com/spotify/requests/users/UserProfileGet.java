package com.spotify.requests.users;


import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;

/**
 * Get public profile information about a Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-profile">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest("users")
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
