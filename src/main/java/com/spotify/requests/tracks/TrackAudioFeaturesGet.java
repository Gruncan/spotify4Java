package com.spotify.requests.tracks;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.TrackAudioFeatures;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;


/**
 * Get audio feature information for a single track identified by its unique Spotify ID.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-audio-features">Spotify Docs</a>
 */
@SpotifyRequest("audio-features")
@SpotifySerialize(TrackAudioFeatures.class)
public class TrackAudioFeaturesGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    /**
     * @param id The id of the song to get
     */
    public TrackAudioFeaturesGet(String id) {
        this.id = id;
    }

}
