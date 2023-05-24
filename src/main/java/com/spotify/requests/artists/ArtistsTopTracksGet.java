package com.spotify.requests.artists;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.Track;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
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
