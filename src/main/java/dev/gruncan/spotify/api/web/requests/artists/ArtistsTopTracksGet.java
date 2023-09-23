package dev.gruncan.spotify.api.web.requests.artists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.tracks.Track;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information about an artist's top tracks by country.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-artists-top-tracks">Spotify Docs</a>
 * <p>Serializes into {@link Track}</p>
 *
 * @see Track
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "artists", end = "top-tracks")
@SpotifySerialize(value = Track.class, isArray = true)
public class ArtistsTopTracksGet implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the artist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private final Country market;


    public ArtistsTopTracksGet(String id, String market) {
        this(id, Country.valueOf(market));
    }

    /**
     * Initializes the {@link ArtistsTopTracksGet} request
     *
     * @param id The Spotify ID of the artist.
     */
    public ArtistsTopTracksGet(String id, Country market) {
        this.id = id;
        this.market = market;
    }

}
