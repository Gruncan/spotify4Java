package dev.gruncan.spotify.api.web.requests.audiobooks;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.audiobooks.Audiobook;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import lombok.Setter;

/**
 * Get Spotify catalog information for several audiobooks identified by their Spotify IDs.<br>
 * Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.<br>
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-album">Spotify Docs</a>
 * <p>Serializes into {@link Audiobook} array</p>
 *
 * @see Audiobook
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("audiobooks")
@SpotifySerialize(value = Audiobook.class, isArray = true)
public class AudiobookSeveralGet implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * Initializes the {@link AudiobookSeveralGet} request
     * @param ids A list of the Spotify IDs.
     */
    public AudiobookSeveralGet(String... ids) {
        this.ids = ids;
    }

}
