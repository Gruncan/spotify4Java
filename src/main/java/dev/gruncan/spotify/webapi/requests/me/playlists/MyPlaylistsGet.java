package dev.gruncan.spotify.webapi.requests.me.playlists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.objects.playlists.PlaylistPage;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestField;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.util.Scope;
import lombok.Setter;

/**
 * Get a list of the playlists owned or followed by the current Spotify user.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-list-of-current-users-playlists">Spotify Docs</a>
 * <p>Serializes into {@link PlaylistPage}</p>
 *
 * @see PlaylistPage
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "me/playlists", authorizations = Scope.PLAYLIST_READ_PRIVATE)
@SpotifySerialize(PlaylistPage.class)
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
