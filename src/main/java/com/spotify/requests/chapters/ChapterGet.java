package com.spotify.requests.chapters;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.chapters.Chapter;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

/**
 * Get Spotify catalog information for a single chapter.<br>
 * Note: Chapters are only available for the US, UK, Ireland, New Zealand and Australia markets.<br>
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-chapter">Spotify Docs</a>
 * <p>Serializes into {@link Chapter}</p>
 *
 * @see Chapter
 * @see AbstractRequest
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("chapters")
@SpotifySerialize(Chapter.class)
public class ChapterGet extends AbstractRequest {


    /**
     * The Spotify ID of the chapter.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An ISO 3166-1 alpha-2 country code. If a country code is specified, only content that is available in that market will be returned.
     */
    @SpotifyRequestField
    private Country market;

    /**
     * Initializes the {@link ChapterGet} request
     * @param id The Spotify ID of the chapter.
     */
    public ChapterGet(String id) {
        this.id = id;
    }

}
