package com.spotify.requests.episodes;

import com.spotify.objects.wrappers.Country;
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
    private Country market;

    public SeveralEpisodesGet(String... ids) {
        this.ids = ids;
    }

}
