package com.spotify.requests.urls.testclasses;

import com.spotify.requests.SpotifyRequestField;
import com.spotify.requests.SpotifyRequestVariant;
import lombok.Setter;

@Setter
public class TestRequestExecutorClass1 implements SpotifyRequestVariant {


    @SpotifyRequestField
    private String field1;

}
