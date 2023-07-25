package dev.gruncan.spotify.requests.urls.testclasses;

import dev.gruncan.spotify.webapi.requests.SpotifyRequest;
import dev.gruncan.spotify.webapi.requests.SpotifyRequestVariant;
import dev.gruncan.spotify.webapi.requests.SpotifySubRequest;
import lombok.Setter;

@SpotifyRequest("url")
@Setter
public class TestSubRequestClass2Executor implements SpotifyRequestVariant {


    @SpotifySubRequest
    private int intField;


}
