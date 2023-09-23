package dev.gruncan.spotify.api.web.objects.artists;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.SpotifyOptional;
import dev.gruncan.spotify.api.web.objects.tracks.SimplifiedTrack;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify SimplifiedArtistObject
 *
 * @see Artist
 * @see SimplifiedTrack
 * @see SpotifyObject
 */
@Getter
@Setter
public class SimplifiedArtist implements SpotifyObject {


    /**
     * Known external URLs for this artist.<br>
     * The Spotify URL for the object.
     */
    @SpotifyOptional
    @SpotifyField(value = "spotify", path = {"external_urls"})
    protected String externalUrls;

    /**
     * A link to the Web API endpoint providing full details of the artist.
     */
    @SpotifyField
    protected String href;

    /**
     * The Spotify ID for the artist.
     */
    @SpotifyField
    protected String id;

    /**
     * The name of the artist.
     */
    @SpotifyField
    protected String name;

    /**
     * The object type.
     */
    @SpotifyField
    protected String type;

    /**
     * The Spotify URI for the artist.
     */
    @SpotifyField
    protected String uri;

}
