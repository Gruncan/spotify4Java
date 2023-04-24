package com.spotify.requests.artists;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.artists.Artist;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single artist identified by their unique Spotify ID.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-artist">Spotify Docs</a>
 * <p>Serializes into {@link Artist}</p>
 *
 * @see Artist
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("artists")
@SpotifySerialize(Artist.class)
public class ArtistGet extends AbstractRequest {


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
