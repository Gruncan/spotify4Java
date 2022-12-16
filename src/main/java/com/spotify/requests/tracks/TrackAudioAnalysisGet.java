package com.spotify.requests.tracks;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;


/**
 * Get a low-level audio analysis for a track in the Spotify catalog. The audio analysis describes the track’s structure and musical content, including rhythm, pitch, and timbre.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-analysis">Spotify Docs</a>
 */
@SpotifyRequest("audio-analysis")
public class TrackAudioAnalysisGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    /**
     * @param token The token of the related spotify api session
     * @param id    The id of the track to be queried
     */
    public TrackAudioAnalysisGet(String id) {
        this.id = id;
    }

}
