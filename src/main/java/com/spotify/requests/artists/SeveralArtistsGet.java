package com.spotify.requests.artists;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.artists.Artist;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.albums.SeveralAlbumsGet;
import lombok.Setter;

/**
 * Get Spotify catalog information for several artists based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-artists">Spotify Docs</a>
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
@SpotifySerialize(value = Artist.class, isArray = true)
public class SeveralArtistsGet extends AbstractRequest {

    /**
     * A list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    @SpotifyRequestField
    private final String[] ids;

    /**
     * Initializes the {@link SeveralAlbumsGet} request
     * @param ids A list of the Spotify IDs for the albums. Maximum: 20 IDs.
     */
    public SeveralArtistsGet(String... ids) {
        this.ids = ids;
    }

}
