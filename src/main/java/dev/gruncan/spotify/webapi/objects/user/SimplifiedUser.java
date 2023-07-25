package dev.gruncan.spotify.webapi.objects.user;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import dev.gruncan.spotify.webapi.objects.wrappers.SpotifyFollowers;
import dev.gruncan.spotify.webapi.objects.wrappers.SpotifyImage;
import dev.gruncan.spotify.webapi.requests.users.UserProfileGet;
import lombok.Getter;


/**
 * Represents a spotify user
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-profile">UserProfileGet</a>
 *
 * @see UserProfileGet
 * @see Profile
 * @see SpotifyFollowers
 * @see SpotifyImage
 * @see SpotifyObject
 */
@Getter
@SpotifyOptional
public class SimplifiedUser implements SpotifyObject {

    /**
     * The name displayed on the user's profile. null if not available.
     */
    @SpotifyField
    private String displayName;

    /**
     * Known public external URLs for this user.<br>
     * The Spotify URL for the object.
     */
    @SpotifyField(value = "spotify", path = "external_urls")
    private String externalUrls;

    /**
     * Information about the followers of this user.
     */
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
     * The user's profile image.
     */
    @SpotifyField
    private SpotifyImage[] images;

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

}
