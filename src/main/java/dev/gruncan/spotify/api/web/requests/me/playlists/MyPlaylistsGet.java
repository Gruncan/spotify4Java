package dev.gruncan.spotify.api.web.requests.me.playlists;

import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.objects.playlists.PlaylistPage;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.util.Scope;
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
