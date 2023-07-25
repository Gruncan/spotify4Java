package dev.gruncan.spotify.webapi.objects.wrappers;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import lombok.Getter;

/**
 * The spotify boolean array for responses to allow for JSON parsing
 */
@Getter
public class SpotifyBooleanArray implements SpotifyObject {


    /**
     * The boolean array of the values
     */
    @SpotifyField("value")
    private Boolean[] values;

}
