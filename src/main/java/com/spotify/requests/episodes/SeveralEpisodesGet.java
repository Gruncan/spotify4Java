package com.spotify.requests.episodes;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

@Setter
@SpotifyRequest("episodes")
public class SeveralEpisodesGet extends AbstractRequest {


    @SpotifyRequestField
    private final String[] ids;

    @SpotifyRequestField
    private Market market;

    public SeveralEpisodesGet(String... ids) {
        this.ids = ids;
    }

}
