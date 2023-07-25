package dev.gruncan.spotify.webapi.objects.artists;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import dev.gruncan.spotify.webapi.objects.tracks.SimplifiedTrack;
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
