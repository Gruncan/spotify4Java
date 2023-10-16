package dev.gruncan.spotify.api.web.requests.shows;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.shows.Show;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single album.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-show">Spotify Docs</a>
 * <p>Serializes into {@link Show}</p>
 *
 * @see Show
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "shows", authorizations = Scope.USER_READ_PLAYBACK_POSITION)
@SpotifySerialize(Show.class)
public class ShowGet implements SpotifyRequestVariant {

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
     * Initializes the {@link ShowGet} request
     * @param id The Spotify ID for the show.
     */
    public ShowGet(String id) {
        this.id = id;
    }

}
