package com.spotify.requests.artists;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Market;
import com.spotify.requests.util.ParameterPair;

/**
 * Get Spotify catalog information about an artist's top tracks by country.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-top-tracks">Spotify Docs</a>
 */
public class ArtistTopTracksGet extends AbstractRequest {

    private final static String URL = "artists/{id}/top-tracks";

    private final String id;

    /**
     * @param id The id of the artist to be queried
     */
    public ArtistTopTracksGet(String id) {
        super(new ParameterPair("markets", Market.class));
        this.id = id;
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL.replace("{id}", this.id));
    }
}
