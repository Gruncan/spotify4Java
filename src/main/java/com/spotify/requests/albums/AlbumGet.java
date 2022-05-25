package com.spotify.requests.albums;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;


/**
 * Get Spotify catalog information for a single album.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-album">Spotify Docs</a>
 */
public class AlbumGet extends AbstractRequest {

    private final static String URL = "albums/{id}/";
    private final String id;


    /**
     * @param token The token of the related spotify api session
     * @param id    The id of the album to be queried
     */
    public AlbumGet(String token, String id) {
        super(token, "markets");
        this.id = id;
    }


    @Override
    public JsonObject execute() {
        String updatedURL = URL.replace("{id}", this.id);

        JsonObject jsonObject = super.requestGet(updatedURL);
        return jsonObject;
    }


}
