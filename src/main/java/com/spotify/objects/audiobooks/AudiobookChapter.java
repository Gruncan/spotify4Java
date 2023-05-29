package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.chapters.SimplifiedChapter;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.requests.audiobooks.AudiobookChaptersGet;
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
