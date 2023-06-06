package com.spotify.requests.util;

import com.spotify.requests.playlists.PlaylistRemoveItemDelete;


/**
 * A wrapper class for easily adding JSON hierarchy to request content body.
 *
 * @see PlaylistRemoveItemDelete
 */
public class SpotifyContentObject {

    /**
     * The uri of the track or episode
     */
    private final String uri;


    public SpotifyContentObject(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return String.format("{\"uri\":\"%s\"}", this.uri);
    }


}
