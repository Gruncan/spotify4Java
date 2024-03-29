package dev.gruncan.spotify.webapi.objects.audiobooks;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify audiobook narrator
 *
 * @see SimplifiedAudiobook
 * @see SpotifyObject
 */
@Getter
@Setter
public class AudiobookNarrator implements SpotifyObject {

    /**
     * The name of the Narrator.
     */
    @SpotifyField
    private String name;

}
