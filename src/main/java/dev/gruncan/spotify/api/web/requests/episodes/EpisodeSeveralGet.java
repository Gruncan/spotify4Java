package dev.gruncan.spotify.api.web.requests.episodes;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.episodes.Episode;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import lombok.Setter;

/**
 * Get Spotify catalog information for several episodes based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-episodes">Spotify Docs</a>
 * <p>Serializes into {@link Episode} array</p>
 *
 * @see Episode
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "episodes", authorizations = Scope.USER_READ_PLAYBACK_POSITION)
@SpotifySerialize(value = Episode.class, isArray = true)
public class EpisodeSeveralGet implements SpotifyRequestVariant {


    /**
     * A list of the Spotify IDs for the episodes. Maximum: 20 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * Initializes the {@link EpisodeSeveralGet} request
     * @param ids A list of the Spotify IDs for the episodes. Maximum: 20 IDs.
     */
    public EpisodeSeveralGet(String... ids) {
        this.ids = ids;
    }

}
