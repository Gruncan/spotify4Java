package dev.gruncan.spotify.requests.me.shows;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.objects.SpotifySerialize;
import dev.gruncan.spotify.objects.shows.ShowPage;
import dev.gruncan.spotify.requests.SpotifyRequest;
import dev.gruncan.spotify.requests.SpotifyRequestField;
import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.requests.util.Scope;
import lombok.Setter;

/**
 * Get a list of shows saved in the current Spotify user's library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-saved-shows">Spotify Docs</a>
 * <p>Serializes into {@link ShowPage}</p>
 *
 * @see ShowPage
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/shows", authorizations = Scope.USER_LIBRARY_READ)
@SpotifySerialize(ShowPage.class)
public class MyShowsGet implements SpotifyRequestVariant {

    /**
     * The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @SpotifyRequestField
    private int offset;

}
