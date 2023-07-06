package dev.gruncan.spotify.requests.playlists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.objects.SpotifySerialize;
import dev.gruncan.spotify.objects.playlists.BrowsedPlaylist;
import dev.gruncan.spotify.requests.SpotifyRequest;
import dev.gruncan.spotify.requests.SpotifyRequestField;
import dev.gruncan.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;

/**
 * Get a list of Spotify featured playlists (shown, for example, on a Spotify player's 'Browse' tab).
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-featured-playlists">Spotify Docs</a>
 * <p>Serializes into {@link BrowsedPlaylist}</p>
 *
 * @see BrowsedPlaylist
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("browse/featured-playlists")
@SpotifySerialize(BrowsedPlaylist.class)
public class PlaylistFeaturedGet implements SpotifyRequestVariant {

    /**
     * A country: an ISO 3166-1 alpha-2 country code. Provide this parameter if you want the list of returned items to be relevant to a particular country. If omitted, the returned items will be relevant to all countries.
     */
    @SpotifyRequestField
    private String country;

    /**
     * The desired language, consisting of a lowercase ISO 639-1 language code and an uppercase ISO 3166-1 alpha-2 country code, joined by an underscore.
     */
    @SpotifyRequestField
    private String locale;

    /**
     * A timestamp in ISO 8601 format: yyyy-MM-ddTHH:mm:ss. Use this parameter to specify the user's local time to get results tailored for that specific date and time in the day. If not provided, the response defaults to the current UTC time.
     */
    @SpotifyRequestField
    private String timestamp;

    /**
     * The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @SpotifyRequestField
    private int offset;

}
