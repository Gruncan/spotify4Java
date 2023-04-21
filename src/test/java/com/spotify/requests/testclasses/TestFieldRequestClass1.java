package com.spotify.requests.testclasses;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

@SpotifyRequest("url")
@Setter
public class TestFieldRequestClass1 extends AbstractRequest {

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
