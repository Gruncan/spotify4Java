package com.spotify.requests.tracks;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;


/**
 * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-tracks">Spotify Docs</a>
 */
@SpotifyRequest("tracks")
public class SeveralTracksGet extends AbstractRequest {


    @SpotifyRequestField
    private final String[] ids;

    @SpotifyRequestField
    private Market market;

    /**
     * @param tracks The array of tracks to get
     */

    public SeveralTracksGet(String... ids) {
        this.ids = ids;
        this.market = null;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

}
