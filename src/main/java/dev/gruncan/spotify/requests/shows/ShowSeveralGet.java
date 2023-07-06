package dev.gruncan.spotify.requests.shows;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.objects.SpotifySerialize;
import dev.gruncan.spotify.objects.shows.SimplifiedShow;
import dev.gruncan.spotify.objects.wrappers.Country;
import dev.gruncan.spotify.requests.SpotifyRequest;
import dev.gruncan.spotify.requests.SpotifyRequestField;
import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;

/**
 * Get Spotify catalog information for several shows based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-shows">Spotify Docs</a>
 * <p>Serializes into {@link SimplifiedShow}</p>
 *
 * @see SimplifiedShow
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("shows")
@SpotifySerialize(value = SimplifiedShow.class, isArray = true)
public class ShowSeveralGet implements SpotifyRequestVariant {


    /**
     * A list of the Spotify IDs for the shows. Maximum: 50 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * Initializes the {@link ShowSeveralGet} request
     * @param ids A list of the Spotify IDs for the shows. Maximum: 50 IDs.
     */
    public ShowSeveralGet(String... ids) {
        this.ids = ids;
    }

}
