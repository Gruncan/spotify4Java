package dev.gruncan.spotify.api.web.requests.episodes;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.episodes.Episode;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single episode identified by its unique Spotify ID.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-episode">Spotify Docs</a>
 * <p>Serializes into {@link Episode}</p>
 *
 * @see Episode
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "episodes", authorizations = Scope.USER_READ_PLAYBACK_POSITION)
@SpotifySerialize(Episode.class)
public class EpisodeGet implements SpotifyRequestVariant {

    /**
     * The Spotify ID for the episode.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;


    /**
     * Initializes the {@link EpisodeGet} request
     * @param id The Spotify ID for the episode.
     */
    public EpisodeGet(String id) {
        this.id = id;
    }

}
