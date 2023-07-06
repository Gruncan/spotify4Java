package dev.gruncan.spotify.objects.audiobooks;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.chapters.SimplifiedChapter;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.requests.audiobooks.AudiobookChaptersGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an audiobook chapter<br>
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-audiobook-chapters">AudiobookChaptersGet</a>
 *
 * @see AudiobookChaptersGet
 * @see AbstractSearchItems
 * @see Audiobook
 * @see SimplifiedChapter
 * @see SpotifyObject
 */
@Getter
@Setter
public class AudiobookChapter extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link SimplifiedChapter} for an album
     */
    @SpotifyField
    private SimplifiedChapter[] items;

}
