package com.spotify.requests.audiobooks;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.albums.Album;
import com.spotify.objects.audiobooks.AudiobookChapter;
import com.spotify.objects.audiobooks.SimplifiedChapter;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.albums.AlbumGet;
import lombok.Setter;

/**
 * Get Spotify catalog information about an audiobook's chapters.<br>
 * Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.<br>
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-audiobook-chapters">Spotify Docs</a>
 * <p>Serializes into {@link AudiobookChapter}</p>
 *
 * @see AudiobookChapter
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "audiobooks", end = "chapters")
@SpotifySerialize(AudiobookChapter.class)
public class AudiobookChaptersGet extends AbstractRequest {

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
     * The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @SpotifyRequestField
    private int offset;


    /**
     * Initializes the {@link AudiobookChaptersGet} request
     * @param id The Spotify ID for the audiobook.
     */
    public AudiobookChaptersGet(String id) {
        this.id = id;
    }
}
