package dev.gruncan.spotify.objects.playlists;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.SpotifyOptional;
import dev.gruncan.spotify.objects.wrappers.SpotifyFollowers;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a contributor to a playlist
 *
 * @see Playlist
 * @see PlaylistTrack
 * @see SpotifyObject
 */
@Getter
@Setter
public class PlaylistContributor implements SpotifyObject {

    /**
     * Known public external URLs for this user.<br>
     * The Spotify URL for the object.
     */
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    /**
     * Information about the followers of this user.
     */
    @SpotifyOptional
    @SpotifyField
    private SpotifyFollowers followers;

    /**
     * A link to the Web API endpoint for this user.
     */
    @SpotifyField
    private String href;

    /**
     * The Spotify user ID for this user.
     */
    @SpotifyField
    private String id;

    /**
     * The object type.
     */
    @SpotifyField
    private String type;

    /**
     * The Spotify URI for this user.
     */
    @SpotifyField
    private String uri;

    /**
     * The name displayed on the user's profile. null if not available.
     */
    @SpotifyOptional
    @SpotifyField
    private String displayName;

}
