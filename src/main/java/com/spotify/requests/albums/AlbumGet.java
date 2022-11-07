package com.spotify.requests.albums;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;


/**
 * Get Spotify catalog information for a single album.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-album">Spotify Docs</a>
 */

@SpotifyRequest("albums/")
public class AlbumGet extends AbstractRequest {

    @SpotifySubRequest
    private final String id;


    /**
     * @param id The id of the album to be queried
     */
    public AlbumGet(String id) {
        this.id = id;
    }


}
