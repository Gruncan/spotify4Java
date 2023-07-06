package dev.gruncan.spotify.objects.search;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.SpotifyOptional;
import dev.gruncan.spotify.objects.search.items.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a search item used across various requests to minimise repetition.
 *
 * @see Search
 * @see SearchItemArtists
 * @see SearchItemsAlbums
 * @see SearchItemsAudiobooks
 * @see SearchItemsEpisodes
 * @see SearchItemsPlaylists
 * @see SearchItemsShows
 * @see SearchItemTracks
 * @see SpotifyObject
 */
@Getter
@Setter
@ToString
public abstract class AbstractSearchItems implements SpotifyObject {

    /**
     * A link to the Web API endpoint returning the full result of the request
     */
    @SpotifyField
    private String href;

    /**
     * The maximum number of items in the response (as set in the query or by default).
     */
    @SpotifyField
    private int limit;

    /**
     * URL to the next page of items. ( null if none)
     */
    @SpotifyOptional
    @SpotifyField
    private String next;

    /**
     * The offset of the items returned (as set in the query or by default)
     */
    @SpotifyOptional
    @SpotifyField
    private int offset;

    /**
     * URL to the previous page of items. ( null if none)
     */
    @SpotifyOptional
    @SpotifyField
    private String previous;

    /**
     * The total number of items available to return.
     */
    @SpotifyField
    private int total;

}

