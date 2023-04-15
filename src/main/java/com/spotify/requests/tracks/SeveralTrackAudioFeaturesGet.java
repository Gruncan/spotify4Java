package com.spotify.requests.tracks;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.TrackAudioFeatures;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;

/**
 * Get audio features for multiple tracks based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-audio-features">Spotify Docs</a>
 */

@SpotifyRequest("audio-features")
@SpotifySerialize(value = TrackAudioFeatures.class, isArray = true)
public class SeveralTrackAudioFeaturesGet extends AbstractRequest {


    @SpotifyRequestField
    private final String[] ids;


    public SeveralTrackAudioFeaturesGet(String... ids) {
        this.ids = ids;
    }


}
