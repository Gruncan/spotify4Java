package com.spotify.requests.tracks;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.Track;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;


/**
 * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-tracks">Spotify Docs</a>
 */

@SpotifyRequest("tracks")
@SpotifySerialize(Track.class)
public class TrackGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    /**
     * @param id The id of the track to be queried
     */
    public TrackGet(String id) {
        this.id = id;
    }

}
