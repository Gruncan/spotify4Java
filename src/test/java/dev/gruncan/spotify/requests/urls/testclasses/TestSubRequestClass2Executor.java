package dev.gruncan.spotify.requests.urls.testclasses;

import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import dev.gruncan.spotify.api.SpotifySubRequest;
import lombok.Setter;

@SpotifyRequest("url")
@Setter
public class TestSubRequestClass2Executor implements SpotifyRequestVariant {


    @SpotifySubRequest
    private int intField;


}
