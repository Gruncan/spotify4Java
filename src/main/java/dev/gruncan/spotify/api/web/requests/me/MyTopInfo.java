package dev.gruncan.spotify.api.web.requests.me;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.wrappers.ArtistTrackPage;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.SpotifySubRequest;
import dev.gruncan.spotify.api.web.requests.util.RestrictedType;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import dev.gruncan.spotify.api.web.requests.util.TimeRange;
import lombok.Setter;

/**
 * Get the current user's top artists or tracks based on calculated affinity.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-top-artists-and-tracks">Spotify Docs</a>
 * <p>Serializes into {@link ArtistTrackPage}</p>
 *
 * @see ArtistTrackPage
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/top", authorizations = Scope.USER_TOP_READ)
@SpotifySerialize(ArtistTrackPage.class)
public class MyTopInfo implements SpotifyRequestVariant {

    /**
     * The type of entity to return.
     */
    @SpotifySubRequest
    private final RestrictedType type;

    /**
     * Over what time frame the affinities are computed.<br>
     * Default: medium_term
     */
    @SpotifyRequestField("time_range")
    private TimeRange timeRange;

    /**
     * The maximum number of items to return.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.
     */
    @SpotifyRequestField
    private int offset;

    /**
     * Initializes the {@link MyTopInfo} request
     * @param type The type of entity to return
     */
    public MyTopInfo(String type){
        this.type = RestrictedType.valueOf(type.toUpperCase());
    }

    /**
     * Initializes the {@link MyTopInfo} request
     * @param type The type of entity to return
     */
    public MyTopInfo(RestrictedType type) {
        this.type = type;
    }

}
