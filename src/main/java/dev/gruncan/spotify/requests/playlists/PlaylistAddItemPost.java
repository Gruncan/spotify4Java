package dev.gruncan.spotify.requests.playlists;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.objects.SpotifySerialize;
import dev.gruncan.spotify.requests.*;
import dev.gruncan.spotify.requests.util.Scope;
import lombok.Setter;


/**
 * Add one or more items to a user's playlist.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/add-tracks-to-playlist">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "playlists", end = "tracks",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.POST)
public class PlaylistAddItemPost implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * The position to insert the items, a zero-based index.
     * If omitted, the items will be appended to the playlist.
     * Items are added in the order they are in the array
     */
    @SpotifyRequestField
    private int position;

    /**
     * A list of Spotify URIs to add, can be track or episode URIs.
     */
    @SpotifyRequestField
    private String[] uris;


    /**
     * An array of the Spotify URIs to add
     */
    @SpotifyRequestContent("uris")
    private final String[] bodyUris;

    /**
     * The position to insert the items, a zero-based index.
     * If omitted, the items will be appended to the playlist.
     * Items are added in the order they are in the array
     */
    @SpotifyRequestContent("position")
    private int bodyPosition;

    /**
     * Initializes the {@link PlaylistAddItemPost} request
     * @param id The Spotify ID of the playlist.
     * @param uris The ids of items to add to the playlist
     */
    public PlaylistAddItemPost(String id, String... uris) {
        this.id = id;
        this.bodyUris = uris;
    }

}
