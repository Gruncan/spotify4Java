package dev.gruncan.spotify.webapi.objects.artists;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import dev.gruncan.spotify.webapi.objects.wrappers.SpotifyFollowers;
import dev.gruncan.spotify.webapi.objects.wrappers.SpotifyImage;
import dev.gruncan.spotify.webapi.requests.artists.ArtistGet;
import lombok.Getter;
import lombok.Setter;


/**
 * Represents a spotify Artist<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-artist">ArtistGet</a>
 *
 * @see ArtistGet
 * @see SimplifiedArtist
 * @see SpotifyObject
 */
@Getter
@Setter
@SpotifyOptional
public class Artist extends SimplifiedArtist implements SpotifyObject {

    /**
     * Information about the followers of the artist.
     */
    @SpotifyField
    private SpotifyFollowers followers;

    /**
     * A list of the genres the artist is associated with. If not yet classified, the array is empty.
     */
    @SpotifyField
    private String[] genres;

    /**
     * Images of the artist in various sizes, widest first.
     */
    @SpotifyField
    private SpotifyImage[] images;

    /**
     * The popularity of the artist. The value will be between 0 and 100, with 100 being the most popular. The artist's popularity is calculated from the popularity of all the artist's tracks.
     */
    @SpotifyField
    private int popularity;

}
