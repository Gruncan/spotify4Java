package dev.gruncan.spotify.webapi.requests.artists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.artists.Artist;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.SpotifySubRequest;

/**
 * Get Spotify catalog information about artists similar to a given artist. Similarity is based on analysis of the Spotify community's listening history.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-artists-related-artists">Spotify Docs</a>
 * <p>Serializes into {@link Artist}</p>
 *
 * @see Artist
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest(value = "artists", end = "related-artists")
@SpotifySerialize(Artist.class)
public class ArtistsRelatedArtistsGet implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the artist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * Initializes the {@link ArtistsRelatedArtistsGet} request
     * @param id The Spotify ID of the artist.
     */
    public ArtistsRelatedArtistsGet(String id) {
        this.id = id;
    }
}
