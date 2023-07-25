package dev.gruncan.spotify.webapi.objects.shows;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.wrappers.Country;
import dev.gruncan.spotify.webapi.objects.wrappers.SpotifyCopyright;
import dev.gruncan.spotify.webapi.objects.wrappers.SpotifyImage;
import dev.gruncan.spotify.webapi.requests.shows.ShowSeveralGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify SimplifiedShowObject
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-multiple-shows">SeveralShowsGet</a>
 *
 * @see ShowSeveralGet
 * @see Show
 * @see SpotifyObject
 */
@Getter
@Setter
public class SimplifiedShow implements SpotifyObject {

    /**
     * A list of the countries in which the show can be played, identified by their ISO 3166-1 alpha-2 code.
     */
    @SpotifyField("available_markets")
    private Country[] markets;

    /**
     * The copyright statements of the show.
     */
    @SpotifyField
    private SpotifyCopyright[] copyrights;

    /**
     * A description of the show. HTML tags are stripped away from this field, use html_description field in case HTML tags are needed.
     */
    @SpotifyField
    private String description;

    /**
     * A description of the show. This field may contain HTML tags.
     */
    @SpotifyField("html_description")
    private String htmlDescription;

    /**
     * Whether or not the show has explicit content (true = yes it does; false = no it does not OR unknown).
     */
    @SpotifyField
    private boolean explicit;

    /**
     * External URLs for this show.<br>
     * The Spotify URL for the object.
     */
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    /**
     * A link to the Web API endpoint providing full details of the show.
     */
    @SpotifyField
    private String href;

    /**
     * The Spotify ID for the show.
     */
    @SpotifyField
    private String id;

    /**
     * The cover art for the show in various sizes, widest first.
     */
    @SpotifyField
    private SpotifyImage[] images;

    /**
     * True if all of the shows episodes are hosted outside of Spotify's CDN. This field might be null in some cases.
     */
    @SpotifyField("is_externally_hosted")
    private boolean isExternallyHosted;

    /**
     * A list of the languages used in the show, identified by their ISO 639 code.
     */
    @SpotifyField
    private String[] languages;

    /**
     * The media type of the show.
     */
    @SpotifyField("media_type")
    private String mediaType;

    /**
     * The name of the episode.
     */
    @SpotifyField
    private String name;

    /**
     * The publisher of the show.
     */
    @SpotifyField
    private String publisher;

    /**
     * The object type.
     */
    @SpotifyField
    private String type;

    /**
     * The Spotify URI for the show.
     */
    @SpotifyField
    private String uri;

    /**
     * The total number of episodes in the show.
     */
    @SpotifyField("total_episodes")
    private int totalEpisodes;
}
