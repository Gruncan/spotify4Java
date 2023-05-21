package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a followers of a Spotify object.
 */
@Setter
@Getter
public class SpotifyFollowers implements SpotifyObject {

    /**
     * This will always be set to null, as the Web API does not support it at the moment.
     */
    @SpotifyOptional
    @SpotifyField
    private String href;

    /**
     * The total number of followers.
     */
    @SpotifyField
    private int total;

}
