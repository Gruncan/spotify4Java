package dev.gruncan.spotify.webapi.objects.tracks;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import dev.gruncan.spotify.webapi.objects.albums.AlbumTracks;
import dev.gruncan.spotify.webapi.objects.artists.SimplifiedArtist;
import dev.gruncan.spotify.webapi.objects.wrappers.Country;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify SimplifiedTrackObject
 *
 * @see AlbumTracks
 * @see Track
 * @see SimplifiedArtist
 * @see SpotifyObject
 */
@Setter
@Getter
@SpotifyOptional
public class SimplifiedTrack implements SpotifyObject {


//    @SpotifyOptional
//    @SpotifyField("artists")
//    private SimplifiedArtist[] simplifiedArtists;

    /**
     * A list of the countries in which the track can be played, identified by their ISO 3166-1 alpha-2 code.
     */
    @SpotifyField("available_markets")
    private Country[] markets;

    /**
     * The disc number (usually 1 unless the album consists of more than one disc).
     */
    @SpotifyField("disc_number")
    private int discNumber;

    /**
     * The track length in milliseconds.
     */
    @SpotifyField("duration_ms")
    private int duration;

    /**
     * Whether or not the track has explicit lyrics ( true = yes it does; false = no it does not OR unknown).
     */
    @SpotifyField
    private boolean explicit;


    /**
     * Known external URLs for this track. <br>
     * The Spotify URL for the object.
     */
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrlsSpotify;

    /**
     * A link to the Web API endpoint providing full details of the track
     */
    @SpotifyField
    private String href;

    /**
     * The Spotify ID for the track
     */
    @SpotifyField
    private String id;

    /**
     * Part of the response when Track Relinking is applied. If true, the track is playable in the given market. Otherwise false
     */
    @SpotifyField("is_playable")
    private boolean isPlayable;

    /**
     * Part of the response when Track Relinking is applied, and the requested track has been replaced with different track.
     * The track in the linked_from object contains information about the originally requested track.
     */
    @SpotifyField("linked_form")
    private String linkedForm;

    /**
     * Included in the response when a content restriction is applied.<br>
     * The reason for the restriction. Supported values:
     * <ul>
     *     <li>market - The content item is not available in the given market.</li>
     *     <li>product - The content item is not available for the user's subscription type.</li>
     *     <li>explicit - The content item is explicit and the user's account is set to not play explicit content.</li>
     *     <li>payment_required - Payment is required to play the content item.</li>
     * </ul>
     * Additional reasons may be added in the future. Note: If you use this field, make sure that your application safely handles unknown values.
     */
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restrictions;

    /**
     * The name of the track.
     */
    @SpotifyField
    private String name;

    /**
     * A link to a 30 second preview (MP3 format) of the track. Can be null
     */
    @SpotifyField("preview_url")
    private String previewURL;

    /**
     * The number of the track. If an album has several discs, the track number is the number on the specified disc.
     */
    @SpotifyField("track_number")
    private int trackNumber;

    /**
     * The object type: "track".
     */
    @SpotifyField
    private String type;

    /**
     * The Spotify URI for the track.
     */
    @SpotifyField
    private String uri;

    /**
     * Whether or not the track is from a local file.
     */
    @SpotifyField("is_local")
    private boolean isLocal;


}
