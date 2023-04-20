package com.spotify.requests.shows;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest(value = "shows", end = "episodes")
public class ShowEpisodesGet extends AbstractRequest {


    @SpotifySubRequest
    private final String id;

    @SpotifyRequestField
    private Market market;

    @SpotifyRequestField
    private int limit;

    @SpotifyRequestField
    private int offset;


    public ShowEpisodesGet(String id) {
        this.id = id;
    }
}
