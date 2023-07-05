package com.spotify.requests.me.player;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.TrackPage;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

/**
 * Get tracks from the current user's recently played tracks.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-recently-played">Spotify Docs</a>
 * <p>Serializes into {@link TrackPage}</p>
 *
 * @see TrackPage
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/player/recently-played", authorizations = Scope.USER_READ_RECENTLY_PLAYED)
@SpotifySerialize(TrackPage.class)
public class MyPlayerRecentlyPlayedGet implements SpotifyRequestVariant {

    /**
     * The maximum number of items to return.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * A Unix timestamp in milliseconds. Returns all items after (but not including) this cursor position.
     * If after is specified, before must not be specified.
     */
    @SpotifyRequestField
    private int after;

    /**
     * A Unix timestamp in milliseconds. Returns all items before (but not including) this cursor position.
     * If before is specified, after must not be specified.
     */
    @SpotifyRequestField
    private int before;

}
