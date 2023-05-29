package com.spotify.objects.chapters;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.audiobooks.AudiobookChapter;
import com.spotify.objects.wrappers.AbstractSpotifyCompilation;
import com.spotify.objects.wrappers.Country;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify SimplifiedChapterObject
 *
 * @see Chapter
 * @see AudiobookChapter
 * @see SpotifyObject
 * @see AbstractSpotifyCompilation
 */
@Getter
@Setter
public class SimplifiedChapter extends AbstractSpotifyCompilation implements SpotifyObject {


    /**
     * A list of the countries in which the chapter can be played, identified by their ISO 3166-1 alpha-2 code.
     */
    @SpotifyOptional
    @SpotifyField("available_markets")
    private Country[] markets;

    /**
     * The number of the chapter
     */
    @SpotifyField("chapter_number")
    private int chapterNumber;


}
