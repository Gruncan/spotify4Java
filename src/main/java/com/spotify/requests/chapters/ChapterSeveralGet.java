package com.spotify.requests.chapters;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.chapters.Chapter;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;

/**
 * Get Spotify catalog information for several chapters identified by their Spotify IDs.<br>
 * Note: Chapters are only available for the US, UK, Ireland, New Zealand and Australia markets.<br>
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-several-chapters">Spotify Docs</a>
 * <p>Serializes into {@link Chapter} array</p>
 *
 * @see Chapter
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("chapters")
@SpotifySerialize(value = Chapter.class, isArray = true)
public class ChapterSeveralGet implements SpotifyRequestVariant {

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
     * Initializes the {@link ChapterSeveralGet} request
     * @param ids A list of the Spotify IDs.
     */
    public ChapterSeveralGet(String... ids) {
        this.ids = ids;
    }

}