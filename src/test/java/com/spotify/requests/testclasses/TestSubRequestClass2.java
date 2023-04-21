package com.spotify.requests.testclasses;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@SpotifyRequest("url")
@Setter
public class TestSubRequestClass2 extends AbstractRequest {


    @SpotifySubRequest
    private int intField;


}
