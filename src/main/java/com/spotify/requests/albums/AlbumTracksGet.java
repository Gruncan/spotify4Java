package com.spotify.requests.albums;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;


/**
 * Get Spotify catalog information about an album’s tracks. Optional parameters can be used to limit the number of tracks returned.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-albums-tracks">Spotify Docs</a>
 */
@SpotifyRequest(value = "albums/", end = "tracks/")
public class AlbumTracksGet extends AbstractRequest {

    private final static String URL = "albums/{id}/tracks";

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private int limit;
    @SpotifyRequestField
    private String market;
    @SpotifyRequestField
    private int offset;

    /**
     * @param id The id of the album to be queried
     */
    public AlbumTracksGet(String id) {
        this.id = id;
        this.limit = -1;
        this.market = null;
        this.offset = -1;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }


}
