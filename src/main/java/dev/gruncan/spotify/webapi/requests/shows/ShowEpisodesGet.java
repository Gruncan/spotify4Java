package dev.gruncan.spotify.webapi.requests.shows;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.shows.ShowEpisodesSearch;
import dev.gruncan.spotify.webapi.objects.wrappers.Country;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.SpotifySubRequest;
import dev.gruncan.spotify.webapi.requests.util.Scope;
import lombok.Setter;

/**
 * Get Spotify catalog information about an show's episodes. Optional parameters can be used to limit the number of episodes returned.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-shows-episodes">Spotify Docs</a>
 * <p>Serializes into {@link ShowEpisodesSearch}</p>
 *
 * @see ShowEpisodesSearch
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "shows", end = "episodes", authorizations = Scope.USER_READ_PLAYBACK_POSITION)
@SpotifySerialize(ShowEpisodesSearch.class)
public class ShowEpisodesGet implements SpotifyRequestVariant {


    /**
     * The Spotify ID for the show.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

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
     * Initializes the {@link ShowEpisodesGet} request
     * @param id The Spotify ID for the show.
     */
    public ShowEpisodesGet(String id) {
        this.id = id;
    }
}
