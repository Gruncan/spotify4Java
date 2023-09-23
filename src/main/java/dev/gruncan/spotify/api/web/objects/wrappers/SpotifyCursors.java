package dev.gruncan.spotify.api.web.objects.wrappers;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.SpotifyOptional;
import lombok.Getter;

/**
 * Represents the cursors used to find the next set of items.
 */
@Getter
@SpotifyOptional
public class SpotifyCursors implements SpotifyObject {


    /**
     * The cursor to use as key to find the next page of items.
     */
    @SpotifyField
    private String after;

    /**
     * The cursor to use as key to find the previous page of items.
     */
    @SpotifyField
    private String before;

}
