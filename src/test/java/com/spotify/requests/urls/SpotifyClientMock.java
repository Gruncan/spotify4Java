package com.spotify.requests.urls;

import com.spotify.SpotifyClient;
import com.spotify.SpotifyResponse;
import com.spotify.exceptions.SpotifyUrlParserException;
import com.spotify.requests.SpotifyRequestExecutor;
import com.spotify.requests.SpotifyRequestVariant;

public class SpotifyClientMock extends SpotifyRequestExecutor implements SpotifyClient {


    @Override
    public SpotifyResponse executeRequest(SpotifyRequestVariant request) {
        return null;
    }

    public String getBuiltURL(SpotifyRequestVariant request) throws SpotifyUrlParserException {
        return super.buildRequestUrl(request);
    }

}
