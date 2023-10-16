package dev.gruncan.spotify.api.web.requests.audiobooks;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.audiobooks.Audiobook;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single audiobook.<br>
 * Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.<br>
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-audiobooks">Spotify Docs</a>
 * <p>Serializes into {@link Audiobook}</p>
 *
 * @see Audiobook
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("audiobooks")
@SpotifySerialize(Audiobook.class)
public class AudiobookGet implements SpotifyRequestVariant {


    /**
     * The Spotify ID for the audiobook.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * Initializes the {@link AudiobookGet} request
     * @param id The Spotify ID for the audiobook.
     */
    public AudiobookGet(String id) {
        this.id = id;
    }

}
