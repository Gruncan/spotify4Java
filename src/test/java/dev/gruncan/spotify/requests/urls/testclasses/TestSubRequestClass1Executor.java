package dev.gruncan.spotify.requests.urls.testclasses;

import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.SpotifySubRequest;
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
