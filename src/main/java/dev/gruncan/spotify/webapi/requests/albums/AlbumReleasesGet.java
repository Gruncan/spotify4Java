package dev.gruncan.spotify.webapi.requests.albums;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.albums.Albums;
import dev.gruncan.spotify.webapi.objects.albums.PageAlbums;
import dev.gruncan.spotify.webapi.objects.wrappers.Country;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import lombok.Setter;


/**
 * Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player's "Browse" tab).
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-new-releases">Spotify Docs</a>
 * <p>Serializes into {@link Albums}</p>
 *
 * @see Albums
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest("browse/new-releases")
@SpotifySerialize(PageAlbums.class)
public class AlbumReleasesGet implements SpotifyRequestVariant {

    /**
     * A country: an ISO 3166-1 alpha-2 country code. Provide this parameter if you want the list of returned items to
     * be relevant to a particular country. If omitted, the returned items will be relevant to all countries.
     */
    @SpotifyRequestField
    private Country country;

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
