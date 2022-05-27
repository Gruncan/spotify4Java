package com.spotify.requests.albums;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPair;


/**
 * Get Spotify catalog information for a single album.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-album">Spotify Docs</a>
 */
public class AlbumGet extends AbstractRequest {

    private final static String URL = "albums/{id}/";
    private final String id;


    /**
     * @param id    The id of the album to be queried
     */
    public AlbumGet(String token, String id) {
        super(new ParameterPair("markets", Market.class));
        this.id = id;
    }


    @Override
    public JSONObject execute(String token) {
        String updatedURL = URL.replace("{id}", this.id);

        JSONObject jsonobject = super.requestGet(token, updatedURL);
        return jsonobject;
    }


}
