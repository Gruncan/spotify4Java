package com.spotify.requests.episodes;

import com.spotify.objects.wrappers.Country;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest("episodes")
//TODO permissions
public class EpisodeGet extends AbstractRequest {

    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Country market;


    public EpisodeGet(String id) {
        this.id = id;
    }

}
