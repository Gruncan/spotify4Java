package com.spotify.requests.artists;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;


/**
 * Get Spotify catalog information for a single artist identified by their unique Spotify ID.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artist">Spotify Docs</a>
 */
public class ArtistGet extends AbstractRequest {

    private final static String URL = "artists/{id}/";
    private final String id;

    /**
     * @param id The id of the album to be queried
     */
    public ArtistGet(String id) {
        super();
        this.id = id;
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL.replace("{id}", this.id));
    }
}
