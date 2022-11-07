package com.spotify.requests.albums;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;


/**
 * Get a list of the albums saved in the current Spotify user's 'Your Music' library.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-users-saved-albums">Spotify Docs</a>
 */
@SpotifyRequest("me/albums/")
public class AlbumsSavedMeGet extends AbstractRequest {


    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private String market;

    @SpotifyRequestField
    private int offset;


    public AlbumsSavedMeGet() {
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
