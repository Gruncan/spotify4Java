package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestContent;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import com.spotify.requests.util.Scope;
import com.spotify.requests.util.SpotifyContentObject;
import lombok.Setter;

import java.util.Arrays;

@Setter
@SpotifyRequest(value = "playlists", end = "tracks",
        authorizations = {Scope.PLAYLIST_MODIFY_PRIVATE, Scope.PLAYLIST_MODIFY_PUBLIC}, method = HttpMethod.DELETE)
public class PlaylistRemoveItemDelete implements SpotifyRequestVariant {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestContent
    private final SpotifyContentObject[] tracks;

    @SpotifyRequestContent("snapshot_id")
    private String snapshotId;

    public PlaylistRemoveItemDelete(String id, String[] uris) {
        this.id = id;
        this.tracks = Arrays.stream(uris)
                .map(SpotifyContentObject::new)
                .toArray(SpotifyContentObject[]::new);
    }

}
