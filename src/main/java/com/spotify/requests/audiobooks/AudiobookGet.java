package com.spotify.requests.audiobooks;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.audiobooks.Audiobook;
import com.spotify.objects.audiobooks.AudiobookChapter;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.albums.AlbumGet;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single audiobook.<br>
 * Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.<br>
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-audiobooks">Spotify Docs</a>
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
@SpotifySerialize(Audiobook.class)
public class AudiobookGet extends AbstractRequest {


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
