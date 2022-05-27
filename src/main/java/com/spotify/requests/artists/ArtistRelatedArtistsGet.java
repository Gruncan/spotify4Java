package com.spotify.requests.artists;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;


/**
 * Get Spotify catalog information about artists similar to a given artist. Similarity is based on analysis of the Spotify community's listening history.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-related-artists">Spotify Docs</a>
 */
public class ArtistRelatedArtistsGet extends AbstractRequest {

    private final static String URL = "artists/{id}/related-artists/";

    private final String id;


    /**
     * @param token The token of the related spotify api session
     * @param id    The id of the artist to be queried
     */
    public ArtistRelatedArtistsGet(String id) {
        super();
        this.id = id;
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL.replace("{id}", this.id));
    }
}
