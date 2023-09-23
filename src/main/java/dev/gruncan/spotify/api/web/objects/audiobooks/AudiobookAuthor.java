package dev.gruncan.spotify.api.web.objects.audiobooks;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify audiobook author
 *
 * @see SimplifiedAudiobook
 * @see SpotifyObject
 */
@Getter
@Setter
public class AudiobookAuthor implements SpotifyObject {

    /**
     * The name of the author.
     */
    @SpotifyField
    private String name;

}

