package com.spotify.requests.urls.testclasses;

import com.spotify.requests.SpotifyRequest;
import com.spotify.requests.SpotifyRequestVariant;
import com.spotify.requests.SpotifySubRequest;
import lombok.Setter;

@SpotifyRequest("url")
@Setter
public class TestSubRequestClass2Executor implements SpotifyRequestVariant {


    @SpotifySubRequest
    private int intField;


}
