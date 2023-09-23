package dev.gruncan.spotify.requests.urls.testclasses;

import dev.gruncan.spotify.api.web.requests.SpotifyRequest;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.api.web.requests.SpotifySubRequest;
import lombok.Setter;

@SpotifyRequest("url")
@Setter
public class TestSubRequestClass1Executor implements SpotifyRequestVariant {

    @SpotifySubRequest
    private String field1;

    @SpotifySubRequest
    private String field2;

    private String field3;


}
