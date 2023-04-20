package com.spotify.requests.capters;

import com.spotify.objects.wrappers.Market;
import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

@Setter
@SpotifyRequest("chapters")
public class SeveralChaptersGet extends AbstractRequest {


    @SpotifyRequestField
    private final String[] ids;

    @SpotifyRequestField
    private Market market;

    public SeveralChaptersGet(String... ids) {
        this.ids = ids;
    }

}
