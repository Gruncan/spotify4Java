package com.spotify.requests.tracks;

import com.spotify.objects.SpotifySerialize;
import com.spotify.objects.tracks.Track;
import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;


/**
 * Get Spotify catalog information for multiple tracks based on their Spotify IDs.
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#/operations/get-several-tracks">Spotify Docs</a>
 */
@SpotifyRequest("tracks")
@SpotifySerialize(value = Track.class, isArray = true)
@Setter
public class SeveralTracksGet extends AbstractRequest {


    @SpotifyRequestField
    private final String[] ids;

    @SpotifyRequestField
    private Country market;

    /**
     * @param tracks The array of tracks to get
     */

    public SeveralTracksGet(String... ids) {
        this.ids = ids;
        this.market = null;
    }


}
