package dev.gruncan.spotify.objects.playlists;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.SpotifyOptional;
import dev.gruncan.spotify.objects.wrappers.SpotifyImage;
import dev.gruncan.spotify.requests.users.UserPlaylistGet;
import lombok.Getter;

/**
 * Represents a simplified spotify playlist
 *
 * @see UserPlaylistGet
 * @see Playlist
 * @see SpotifyImage
 * @see PlaylistContributor
 * @see SpotifyObject
 */
@Getter
public class SimplifiedPlaylist implements SpotifyObject {


    /**
     * true if the owner allows other users to modify the playlist.
     */
    @SpotifyField("collaborative")
    private boolean isCollaborative;

    /**
     * The playlist description. Only returned for modified, verified playlists, otherwise null.
     */
    @SpotifyOptional
    @SpotifyField
    private String description;

    /**
     * Known external URLs for this playlist.<br>
     * Information about the followers of the playlist.
     */
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    /**
     * A link to the Web API endpoint providing full details of the playlist.
     */
    @SpotifyField
    private String href;

    /**
     * The Spotify ID for the playlist.
     */
    @SpotifyField
    private String id;

    /**
     * Images for the playlist. The array may be empty or contain up to three images. The images are returned by size in descending order. See Working with Playlists. Note: If returned, the source URL for the image (url) is temporary and will expire in less than a day.
     */
    @SpotifyField
    private SpotifyImage[] images;

    /**
     * The name of the playlist.
     */
    @SpotifyField
    private String name;

    /**
     * The user who owns the playlist
     */
    @SpotifyField
    private PlaylistContributor owner;

    /**
     * The playlist's public/private status: true the playlist is public, false the playlist is private, null the playlist status is not relevant.
     */
    @SpotifyField("is_public")
    private boolean isPublic;

    /**
     * The version identifier for the current playlist. Can be supplied in other requests to target a specific playlist version
     */
    @SpotifyField("snapshot_id")
    private String snapshotID;

    /**
     * The tracks of the playlist.
     */
    @SpotifyField
    private PlaylistTracksSearch tracks;

    /**
     * The object type: "playlist"
     */
    @SpotifyField
    private String type;

    /**
     * The Spotify URI for the playlist.
     */
    @SpotifyField
    private String uri;

}
