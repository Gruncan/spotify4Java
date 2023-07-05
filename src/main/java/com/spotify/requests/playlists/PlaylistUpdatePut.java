package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.*;
import com.spotify.requests.util.Scope;
import lombok.Setter;

/**
 * Either reorder or replace items in a playlist depending on the request's parameters.<br>
 * To reorder items, set rangeStart, insertBefore, rangeLength and snapshotId.<br>
 * To replace items, set uris or bodyUris.<br>
 * Replacing items in a playlist will overwrite its existing items. <br>
 * This operation can be used for replacing or clearing items in a playlist.<br>
 * <i>Replace and reorder are mutually exclusive operations which share the same endpoint, but have different parameters.
 * These operations can't be applied together in a single request.</i><br>
 * <a href="https://developer.spotify.com/documentation/web-api/reference/reorder-or-replace-playlists-tracks">Spotify Docs</a>
 *
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "playlists", end = "tracks",
        authorizations = {Scope.PLAYLIST_MODIFY_PUBLIC, Scope.PLAYLIST_MODIFY_PRIVATE}, method = HttpMethod.PUT)
public class PlaylistUpdatePut implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * A list of Spotify URIs to set, can be track or episode URIs.
     */
    @SpotifyRequestField
    private String[] uris;

    /**
     * A list of Spotify URIs to set, can be track or episode URIs.
     */
    @SpotifyRequestContent("uris")
    private String[] bodyUris;

    /**
     * The position of the first item to be reordered.
     */
    @SpotifyRequestContent("range_start")
    private int rangeStart;

    /**
     * The position where the items should be inserted.
     * To reorder the items to the end of the playlist, simply set insertBefore to the position after the last item.
     */
    @SpotifyRequestContent("insert_before")
    private int insertBefore;

    /**
     * The amount of items to be reordered. Defaults to 1 if not set.
     * The range of items to be reordered begins from the rangeStart position, and includes the rangeLength subsequent items.
     */
    @SpotifyRequestContent("range_length")
    private int rangeLength;

    /**
     *
     */
    @SpotifyRequestContent("snapshot_id")
    private String snapshotId;

    /**
     * Initializes the {@link PlaylistUpdatePut} request
     * @param id The Spotify ID of the playlist.
     */
    public PlaylistUpdatePut(String id) {
        this.id = id;
    }


}
