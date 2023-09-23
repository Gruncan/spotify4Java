package dev.gruncan.spotify.api.web.objects.wrappers;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.SpotifyOptional;
import lombok.Getter;
import lombok.Setter;

/**
 * A single spotify image
 *
 * @see SpotifyObject
 */
@Getter
@Setter
public class SpotifyImage implements SpotifyObject {

    /**
     * The source URL of the image
     */
    @SpotifyField
    private String url;

    /**
     * The image height in pixels.
     */
    @SpotifyOptional
    @SpotifyField
    private int height;

    /**
     * The image width in pixels.
     */
    @SpotifyOptional
    @SpotifyField
    private int width;


}
