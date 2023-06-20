package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import com.spotify.requests.util.SpotifyContentObject;
import lombok.Setter;

import java.util.Arrays;

/**
 * Remove one or more items from a user's playlist.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/remove-tracks-playlist">Spotify Docs</a>
 * <p>Serializes into {@link ?}</p>
 *
 * @see ?
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@Setter
@SpotifyRequest(value = "playlists", end = "tracks",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.DELETE)
public class PlaylistRemoveItemDelete implements SpotifyRequestVariant {

    /**
     * The Spotify ID of the playlist.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * An array of objects containing Spotify URIs of the tracks or episodes to remove
     */
    @SpotifyRequestContent
    private final SpotifyContentObject[] tracks;

    /**
     * The playlist's snapshot ID against which you want to make the changes. The API will validate that the specified items
     * exist and in the specified positions and make the changes, even if more recent changes have been made to the playlist.
     */
    @SpotifyRequestContent("snapshot_id")
    private String snapshotId;


    public PlaylistRemoveItemDelete(String id, String... uris) {
        this.id = id;
        this.tracks = Arrays.stream(uris)
                .map(SpotifyContentObject::new)
                .toArray(SpotifyContentObject[]::new);
    }

}
