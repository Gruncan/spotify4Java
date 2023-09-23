package dev.gruncan.spotify.api.web.objects.chapters;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.SpotifyOptional;
import dev.gruncan.spotify.api.web.objects.audiobooks.AudiobookChapter;
import dev.gruncan.spotify.api.web.objects.wrappers.AbstractSpotifyCompilation;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
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
