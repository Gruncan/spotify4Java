package com.spotify.requests.testclasses;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@SpotifyRequest("url")
@Setter
public class TestSubRequestClass1 extends AbstractRequest {

    @SpotifySubRequest
    private String field1;

    @SpotifySubRequest
    private String field2;

    private String field3;


}
