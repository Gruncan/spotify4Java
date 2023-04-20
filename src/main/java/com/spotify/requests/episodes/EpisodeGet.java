package com.spotify.requests.episodes;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;

@SpotifyRequest("episodes")
//TODO permissions
public class EpisodeGet extends AbstractRequest {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Market market;


    public EpisodeGet(String id) {
        this.id = id;
    }

}
