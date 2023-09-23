package dev.gruncan.spotify.api.web.requests.playlists;

import dev.gruncan.http.HttpMethod;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.api.web.objects.SpotifySerialize;
import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestContent;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.SpotifySubRequest;
import dev.gruncan.spotify.api.web.requests.util.Scope;
import dev.gruncan.spotify.api.web.requests.util.SpotifyUriObject;
import dev.gruncan.spotify.api.web.requests.util.SpotifyUriWrapper;
import lombok.Setter;

import java.util.Arrays;

/**
 * Remove one or more items from a user's playlist.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/remove-tracks-playlist">Spotify Docs</a>
 *
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
    private final SpotifyUriWrapper[] tracks;

    /**
     * The playlist's snapshot ID against which you want to make the changes. The API will validate that the specified items
     * exist and in the specified positions and make the changes, even if more recent changes have been made to the playlist.
     */
    @SpotifyRequestContent("snapshot_id")
    private String snapshotId;


    public PlaylistRemoveItemDelete(String id, String... uris) {
        this.id = id;
        this.tracks = Arrays.stream(uris)
                .map(SpotifyUriObject::new)
                .map(SpotifyUriWrapper::new)
                .toArray(SpotifyUriWrapper[]::new);
    }

    public PlaylistRemoveItemDelete(String id, SpotifyUriObject... uris){
        this.id = id;
        this.tracks = Arrays.stream(uris)
                .map(SpotifyUriWrapper::new)
                .toArray(SpotifyUriWrapper[]::new);
    }

}
