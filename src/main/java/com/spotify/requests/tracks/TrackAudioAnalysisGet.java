package com.spotify.requests.tracks;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.TrackAudioAnalysis;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestExecutor;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;


/**
 * Get a low-level audio analysis for a track in the Spotify catalog. The audio analysis describes the track's structure and musical content, including rhythm, pitch, and timbre.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-audio-analysis">Spotify Docs</a>
 * <p>Serializes into {@link TrackAudioAnalysis}</p>
 *
 * @see TrackAudioAnalysis
 * @see SpotifyRequestExecutor
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest("audio-analysis")
@SpotifySerialize(TrackAudioAnalysis.class)
public class TrackAudioAnalysisGet implements SpotifyRequestVariant {

    /**
     * The Spotify ID for the track.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * Initializes the {@link TrackAudioAnalysisGet} request
     * @param id The Spotify ID for the track.
     */
    public TrackAudioAnalysisGet(String id) {
        this.id = id;
    }

}
