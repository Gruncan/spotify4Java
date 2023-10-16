package dev.gruncan.spotify.requests.urls;

import dev.gruncan.spotify.SpotifyClient;
import dev.gruncan.spotify.SpotifyResponse;
import dev.gruncan.spotify.exceptions.SpotifyUrlParserException;
import dev.gruncan.spotify.api.SpotifyRequestExecutor;
import dev.gruncan.spotify.api.SpotifyRequestVariant;

public class SpotifyClientMock extends SpotifyRequestExecutor implements SpotifyClient {


    @Override
    public SpotifyResponse executeRequest(SpotifyRequestVariant request) {
        return null;
    }


    public String getBuiltUrlE(SpotifyRequestVariant request) throws SpotifyUrlParserException {
        return super.buildRequestUrl(request);
    }

    public String getBuiltURL(SpotifyRequestVariant request) {
        try {
            return super.buildRequestUrl(request);
        } catch (SpotifyUrlParserException e) {
            return null;
        }
    }

}
