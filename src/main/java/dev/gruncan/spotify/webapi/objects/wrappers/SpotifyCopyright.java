package dev.gruncan.spotify.webapi.objects.wrappers;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;


/**
 * Represents a spotify CopyrightObject
 */
@Getter
@Setter
public class SpotifyCopyright implements SpotifyObject {

    /**
     * The copyright text for this content.
     */
    @SpotifyOptional
    @SpotifyField
    private String text;

    /**
     * The type of copyright: C = the copyright, P = the sound recording (performance) copyright.
     */
    @SpotifyOptional
    @SpotifyField
    private String type;

}
