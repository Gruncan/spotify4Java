package com.spotify.requests.urls.testclasses;

import com.spotify.requests.AbstractRequest;
import com.spotify.requests.SpotifyRequestField;
import lombok.Setter;

@Setter
public class TestRequestClass1 extends AbstractRequest {


    @SpotifyRequestField
    private String field1;

}
