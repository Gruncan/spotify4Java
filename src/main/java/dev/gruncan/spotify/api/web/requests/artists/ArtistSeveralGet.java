package dev.gruncan.spotify.api.web.requests.artists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.artists.Artist;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import lombok.Setter;

/**
 * Get Spotify catalog information for several artists based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-artists">Spotify Docs</a>
 * <p>Serializes into {@link Artist} array</p>
 *
 * @see Artist
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("artists")
@SpotifySerialize(value = Artist.class, isArray = true)
public class ArtistSeveralGet implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * Initializes the {@link ArtistSeveralGet} request
     * @param ids A list of the Spotify IDs for the artists. Maximum: 20 IDs.
     */
    public ArtistSeveralGet(String... ids) {
        this.ids = ids;
    }

}
