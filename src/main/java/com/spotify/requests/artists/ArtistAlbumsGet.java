package com.spotify.requests.artists;

import com.spotify.json.JSONObject;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.util.Group;
import com.spotify.requests.util.ParameterPairBuilder;


/**
 * Get Spotify catalog information about an artist's albums.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-an-artists-albums">Spotify Docs</a>
 */
public class ArtistAlbumsGet extends AbstractRequest {


    private final static String URL = "artists/{id}/albums";

    private final String id;

    /**
     * @param id The id of the artist to be queried
     */
    public ArtistAlbumsGet(String id) {

        super(new ParameterPairBuilder().addKeys("include_groups", "limit", "market", "offset")
                .addClasses(Group[].class, Integer.class, Integer.class).build());
        this.id = id;
    }

    @Override
    public JSONObject execute(String token) {
        return super.requestGet(token, URL.replace("{id}", this.id));
    }
}
