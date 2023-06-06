package com.spotify.requests.tracks;

import com.spotify.SpotifyResponse;
import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.TrackAudioFeatures;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;

/**
 * Get audio features for multiple tracks based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/get-several-audio-features">Spotify Docs</a>
 * <p>Serializes into {@link TrackAudioFeatures} array</p>
 *
 * @see TrackAudioFeatures
 * @see SpotifyRequestVariant
 * @see SpotifyRequest
 * @see SpotifySerialize
 * @see SpotifyResponse
 */
@SpotifyRequest("audio-features")
@SpotifySerialize(value = TrackAudioFeatures.class, isArray = true)
public class TrackAudioFeatureSeveralGet implements SpotifyRequestVariant {

    /**
     * A list of the Spotify IDs for the tracks. Maximum: 100 IDs
     */
    @SpotifyRequestField
    private final String[] ids;


    /**
     * Initializes the {@link TrackAudioFeatureSeveralGet} request
     * @param ids A list of the Spotify IDs for the tracks. Maximum: 100 IDs
     */
    public TrackAudioFeatureSeveralGet(String... ids) {
        this.ids = ids;
    }


}
