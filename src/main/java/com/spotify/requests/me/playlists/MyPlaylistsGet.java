package com.spotify.requests.me.playlists;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.util.Scope;
import lombok.Setter;

/**
 * Get a list of the playlists owned or followed by the current Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-list-of-current-users-playlists">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/playlists", authorizations = Scope.PLAYLIST_READ_PRIVATE)
public class MyPlaylistsGet implements SpotifyRequestVariant {

    /**
     * The maximum number of items to return.
     */
    @SpotifyRequestField
    private int limit;

    /**
     * The index of the first playlist to return
     */
    @SpotifyRequestField
    private int offset;

}
