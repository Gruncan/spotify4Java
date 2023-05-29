package com.spotify.requests.tracks;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.TrackAudioFeatures;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;


/**
 * Get audio feature information for a single track identified by its unique Spotify ID.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-audio-features">Spotify Docs</a>
 * <p>Serializes into {@link TrackAudioFeatures}</p>
 *
 * @see TrackAudioFeatures
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest("audio-features")
@SpotifySerialize(TrackAudioFeatures.class)
public class TrackAudioFeaturesGet implements SpotifyRequestVariant {

    /**
     * The Spotify ID for the track.
     */
    @SpotifySubRequest
    private final String id;

    /**
     * Initializes the {@link TrackAudioFeaturesGet} request
     * @param id The Spotify ID for the track.
     */
    public TrackAudioFeaturesGet(String id) {
        this.id = id;
    }

}
