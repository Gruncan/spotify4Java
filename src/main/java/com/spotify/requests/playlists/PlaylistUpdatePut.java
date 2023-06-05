package com.spotify.requests.playlists;

import com.http.HttpMethod;
import com.spotify.requests.*;
import com.spotify.requests.util.Scope;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "playlists", end = "tracks",
        authorizations = {Scope.PLAYLIST_MODIFY_PUBLIC, Scope.PLAYLIST_MODIFY_PRIVATE}, method = HttpMethod.PUT)
public class PlaylistUpdatePut implements SpotifyRequestVariant {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private String[] uris;

    @SpotifyRequestContent("uris")
    private String[] bodyUris;

    @SpotifyRequestContent("range_start")
    private int rangeStart;

    @SpotifyRequestContent("insert_before")
    private int insertBefore;

    @SpotifyRequestContent("range_length")
    private int rangeLength;

    @SpotifyRequestContent("snapshot_id")
    private String snapshotId;


    public PlaylistUpdatePut(String id) {
        this.id = id;
    }


}
