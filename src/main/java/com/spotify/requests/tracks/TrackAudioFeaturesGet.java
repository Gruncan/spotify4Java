package com.spotify.requests.tracks;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;


/**
 * Get audio feature information for a single track identified by its unique Spotify ID.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-features">Spotify Docs</a>
 */
public class TrackAudioFeaturesGet extends AbstractRequest {

    private final static String URL = "audio-features/{id}/";

    private final String id;

    /**
     * @param token The token of the related spotify api session
     * @param id    The id of the song to get
     */
    public TrackAudioFeaturesGet(String token, String id) {
        super(token);
        this.id = id;
    }

    @Override
    public JsonObject execute() {
        return super.requestGet(URL.replace("{id}", this.id));
    }
}
