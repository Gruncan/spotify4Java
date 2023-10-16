package dev.gruncan.spotify.requests.urls.testclasses;

import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;
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
