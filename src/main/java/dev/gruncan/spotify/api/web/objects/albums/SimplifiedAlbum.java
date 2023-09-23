package dev.gruncan.spotify.api.web.objects.albums;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.SpotifyOptional;
import dev.gruncan.spotify.api.web.objects.artists.ArtistAlbums;
import dev.gruncan.spotify.api.web.objects.wrappers.Country;
import dev.gruncan.spotify.api.web.objects.wrappers.SpotifyCopyright;
import dev.gruncan.spotify.api.web.objects.wrappers.SpotifyExternalID;
import dev.gruncan.spotify.api.web.objects.wrappers.SpotifyImage;
import dev.gruncan.spotify.api.web.requests.artists.ArtistsAlbumsGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify SimplifiedAlbumObject
 *
 * @see Album
 * @see ArtistAlbums
 * @see ArtistsAlbumsGet
 * @see SpotifyObject
 */
@Getter
@Setter
public class SimplifiedAlbum implements SpotifyObject {

    /**
     * The type of the album.
     */
    @SpotifyField("album_type")
    private String albumType;

    /**
     * The number of tracks in the album.
     */
    @SpotifyField("total_tracks")
    private int totalTracks;

    /**
     * The markets in which the album is available: ISO 3166-1 alpha-2 country codes. NOTE: an album is considered available in a market when at least 1 of its tracks is available in that market.
     */
    @SpotifyField("available_markets")
    private Country[] markets;

    /**
     * Known external URLs for this album.<br>
     * The Spotify URL for the object.
     */
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    /**
     * A link to the Web API endpoint providing full details of the album.
     */
    @SpotifyField
    private String href;

    /**
     * The Spotify ID for the album.
     */
    @SpotifyField
    private String id;

    /**
     * The cover art for the album in various sizes, widest first.
     */
    @SpotifyField
    private SpotifyImage[] images;

    /**
     * The name of the album. In case of an album takedown, the value may be an empty string
     */
    @SpotifyField
    private String name;

    /**
     * The date the album was first released.
     */
    @SpotifyField("release_date")
    private String releaseDate;

    /**
     * The precision with which release_date value is known.
     */
    @SpotifyField("release_date_precision")
    private String releaseDatePrecision;

    /**
     * Included in the response when a content restriction is applied.<br>
     * The reason for the restriction. Albums may be restricted if the content is not available in a given market, to the user's subscription type, or when the user's account is set to not play explicit content. Additional reasons may be added in the future.
     */
    @SpotifyOptional
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restrictions;

    /**
     * The object type.
     */
    @SpotifyField
    private String type;

    /**
     * The Spotify URI for the album.
     */
    @SpotifyField
    private String uri;

    /**
     * The copyright statements of the album.
     */
    @SpotifyOptional
    @SpotifyField
    private SpotifyCopyright[] copyrights;

    /**
     * Known external IDs for the album.
     */
    @SpotifyOptional
    @SpotifyField("external_ids")
    private SpotifyExternalID externalIDS;

    /**
     * A list of the genres the album is associated with. If not yet classified, the array is empty.
     */
    @SpotifyOptional
    @SpotifyField
    private String[] genres;

    /**
     * The label associated with the album.
     */
    @SpotifyOptional
    @SpotifyField
    private String label;

    /**
     * The popularity of the album. The value will be between 0 and 100, with 100 being the most popular.
     */
    @SpotifyOptional
    @SpotifyField
    private int popularity;

}
