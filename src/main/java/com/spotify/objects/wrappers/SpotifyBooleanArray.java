package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
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
