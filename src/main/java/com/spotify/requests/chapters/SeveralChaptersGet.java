package com.spotify.requests.chapters;

import com.spotify.objects.wrappers.Country;
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
    private Country market;

    public SeveralChaptersGet(String... ids) {
        this.ids = ids;
    }

}
