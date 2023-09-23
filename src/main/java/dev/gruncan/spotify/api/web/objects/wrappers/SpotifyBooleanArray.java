package dev.gruncan.spotify.api.web.objects.wrappers;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
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
