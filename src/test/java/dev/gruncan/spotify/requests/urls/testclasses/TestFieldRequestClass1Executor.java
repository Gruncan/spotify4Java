package dev.gruncan.spotify.requests.urls.testclasses;

import dev.gruncan.spotify.api.SpotifyRequest;
import dev.gruncan.spotify.api.SpotifyRequestField;
import dev.gruncan.spotify.api.SpotifyRequestVariant;
import lombok.Setter;

@SpotifyRequest("url")
@Setter
public class TestFieldRequestClass1Executor implements SpotifyRequestVariant {

    @SpotifyRequestField
    private String field1;

    @SpotifyRequestField("FIELD2")
    private String field2;

    @SpotifyRequestField
    private String field3;

    @SpotifyRequestField
    private int field4;

    @SpotifyRequestField
    private String field5;

}
