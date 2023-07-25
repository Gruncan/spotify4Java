package dev.gruncan.spotify.webapi.objects.player;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import lombok.Getter;

/**
 * Represents the current player context
 *
 * @see PlaybackState
 * @see SpotifyObject
 *
 */
@Getter
public class PlayerContext implements SpotifyObject {

    /**
     * The object type, e.g. "artist", "playlist", "album", "show".
     */
    @SpotifyField
    private String type;

    /**
     * A link to the Web API endpoint providing full details of the track.
     */
    @SpotifyField
    private String href;

    /**
     * External URLs for this context.
     * The Spotify URL for the object.
     */
    @SpotifyField(value = "spotify", path = "external_urls")
    private String externalUrls;

    /**
     * The Spotify URI for the context.
     */
    @SpotifyField
    private String uri;

}
