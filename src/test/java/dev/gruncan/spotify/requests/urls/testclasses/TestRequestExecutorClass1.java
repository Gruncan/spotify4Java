package dev.gruncan.spotify.requests.urls.testclasses;

import dev.gruncan.spotify.api.web.requests.SpotifyRequestField;
import dev.gruncan.spotify.api.web.requests.SpotifyRequestVariant;
import lombok.Setter;

@Setter
public class TestRequestExecutorClass1 implements SpotifyRequestVariant {


    @SpotifyRequestField
    private String field1;

}
