package com.spotify.requests.tracks;

import com.spotify.json.JsonObject;
import com.spotify.requests.AbstractRequest;


/**
 * Get a low-level audio analysis for a track in the Spotify catalog. The audio analysis describes the track’s structure and musical content, including rhythm, pitch, and timbre.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-analysis">Spotify Docs</a>
 */
public class TrackAudioAnalysisGet extends AbstractRequest {

    private final static String URL = "audio-analysis/{id}/";

    private final String id;

    /**
     * @param token The token of the related spotify api session
     * @param id    The id of the track to be queried
     */
    public TrackAudioAnalysisGet(String id) {
        super();
        this.id = id;
    }

    @Override
    public JsonObject execute(String token) {
        return super.requestGet(token, URL.replace("{id}", this.id));
    }
}
