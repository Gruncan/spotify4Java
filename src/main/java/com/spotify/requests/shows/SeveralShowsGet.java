package com.spotify.requests.shows;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@Setter
@SpotifyRequest("shows")
public class SeveralShowsGet extends AbstractRequest {


    @SpotifySubRequest
    private final String[] ids;

    @SpotifyRequestField
    private Market market;

    public SeveralShowsGet(String... ids) {
        this.ids = ids;
    }

}
