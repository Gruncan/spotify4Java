package com.spotify.requests.audiobooks;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.audiobooks.Audiobook;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.albums.SeveralAlbumsGet;
import lombok.Setter;

/**
 * Get Spotify catalog information for several audiobooks identified by their Spotify IDs.<br>
 * Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.<br>
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-album">Spotify Docs</a>
 * <p>Serializes into {@link Audiobook}</p>
 *
 * @see Audiobook
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("audiobooks")
@SpotifySerialize(value = Audiobook.class, isArray = true)
public class SeveralAudioBooksGet extends AbstractRequest {

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
     * Initializes the {@link SeveralAlbumsGet} request
     * @param ids A list of the Spotify IDs.
     */
    public SeveralAudioBooksGet(String... ids) {
        this.ids = ids;
    }

}
