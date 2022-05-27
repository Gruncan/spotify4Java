package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPairBuilder;


/**
 * Get Spotify catalog information about an album’s tracks. Optional parameters can be used to limit the number of tracks returned.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-albums-tracks">Spotify Docs</a>
 */
public class AlbumTracksGet extends AbstractRequest {

    private final static String URL = "albums/{id}/tracks";
    private final String id;

    /**
     * @param id The id of the album to be queried
     */
    public AlbumTracksGet(String id) {
        super(new ParameterPairBuilder().addKeys("limit", "market", "offset")
                .addClasses(int.class, Market.class, int.class).build());
        this.id = id;
    }

    @Override
    public JsonObject execute(String token) {
        return super.requestGet(token, URL.replace("{id}", this.id));
    }
}
