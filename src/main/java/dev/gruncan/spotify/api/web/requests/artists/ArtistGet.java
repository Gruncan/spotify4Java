package dev.gruncan.spotify.api.web.requests.artists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.artists.Artist;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single artist identified by their unique Spotify ID.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-artist">Spotify Docs</a>
 * <p>Serializes into {@link Artist}</p>
 *
 * @see Artist
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("artists")
@SpotifySerialize(Artist.class)
public class ArtistGet implements SpotifyRequestVariant {


    /**
     * The Spotify ID of the artist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * Initializes the {@link ArtistGet} request
     * @param id The Spotify ID of the artist.
     */
    public ArtistGet(String id) {
        this.id = id;
    }


}
