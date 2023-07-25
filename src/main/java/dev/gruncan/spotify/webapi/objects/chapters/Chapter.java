package dev.gruncan.spotify.webapi.objects.chapters;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.audiobooks.SimplifiedAudiobook;
import dev.gruncan.spotify.webapi.requests.chapters.ChapterGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify chapter<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-chapter">ChapterGet</a>
 *
 * @see ChapterGet
 * @see SimplifiedChapter
 * @see SimplifiedAudiobook
 * @see SpotifyObject
 */
@Getter
@Setter
public class Chapter extends SimplifiedChapter implements SpotifyObject {


    /**
     * The audiobook for which the chapter belongs.
     */
    @SpotifyField
    private SimplifiedAudiobook audiobook;

}
