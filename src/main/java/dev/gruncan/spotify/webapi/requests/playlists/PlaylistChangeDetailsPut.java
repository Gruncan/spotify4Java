package dev.gruncan.spotify.webapi.requests.playlists;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.webapi.objects.SpotifySerialize;
import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestContent;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.SpotifySubRequest;
import dev.gruncan.spotify.webapi.requests.util.Scope;
import lombok.Setter;

/**
 * Change a playlist's name and public/private state. (The user must, of course, own the playlist.)
 * <a href="https://developer.spotify.com/documentation/web-api/reference/change-playlist-details">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "playlists", authorizations = {Scope.PLAYLIST_MODIFY_PUBLIC, Scope.PLAYLIST_MODIFY_PRIVATE},
        method = HttpMethod.PUT)
public class PlaylistChangeDetailsPut implements SpotifyRequestVariant {


    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    @SpotifyRequestContent
    private String name;

    @SpotifyRequestContent
    private boolean isPublic;

    @SpotifyRequestContent
    private boolean isCollaborative;

    @SpotifyRequestContent
    private String description;

    /**
     * Initializes the {@link PlaylistChangeDetailsPut} request
     * @param id The Spotify ID of the playlist.
     */
    public PlaylistChangeDetailsPut(String id){
        this.id = id;
    }

}
