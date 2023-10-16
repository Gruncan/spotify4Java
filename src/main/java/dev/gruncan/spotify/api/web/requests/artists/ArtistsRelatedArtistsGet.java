package dev.gruncan.spotify.api.web.requests.artists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.artists.Artist;
import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;

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
