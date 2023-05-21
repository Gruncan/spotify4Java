package com.spotify.requests.urls.testclasses;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
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
