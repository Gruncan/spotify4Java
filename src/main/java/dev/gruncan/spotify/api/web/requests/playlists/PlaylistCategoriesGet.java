package dev.gruncan.spotify.api.web.requests.playlists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.playlists.BrowsedPlaylist;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get a list of Spotify playlists tagged with a particular category.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-categories-playlists">Spotify Docs</a>
 * <p>Serializes into {@link BrowsedPlaylist}</p>
 *
 * @see BrowsedPlaylist
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "browse/categories", end = "playlists")
@SpotifySerialize(BrowsedPlaylist.class)
public class PlaylistCategoriesGet implements SpotifyRequestVariant {

    /**
     * The Spotify category ID for the category.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * A country: an ISO 3166-1 alpha-2 country code. Provide this parameter to ensure that the category exists for a particular country.
     */
    @SpotifyRequestField
    private Country country;

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

    /**
     * Initializes the {@link PlaylistCategoriesGet} request
     * @param id The Spotify category ID for the category.
     */
    public PlaylistCategoriesGet(String id) {
        this.id = id;
    }

}
