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
     * @param token The token of the related spotify api session
     * @param id    The id of the album to be queried
     */
    public AlbumTracksGet(String token, String id) {
        super(token, new ParameterPairBuilder().addKeys("limit", "market", "offset")
                .addClasses(int.class, Market.class, int.class).build());
        this.id = id;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{id}", this.id));
    }
}
