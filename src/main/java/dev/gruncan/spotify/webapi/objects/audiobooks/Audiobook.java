package dev.gruncan.spotify.webapi.objects.audiobooks;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.requests.audiobooks.AudiobookGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an spotify audiobook<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-audiobook">AudiobookGet</a>
 *
 * @see AudiobookGet
 * @see SimplifiedAudiobook
 * @see AudiobookChapter
 * @see SpotifyObject
 */
@Getter
@Setter
public class Audiobook extends SimplifiedAudiobook implements SpotifyObject {

    /**
     * The chapters of the audiobook.
     */
    @SpotifyField
    private AudiobookChapter[] chapters;


}
