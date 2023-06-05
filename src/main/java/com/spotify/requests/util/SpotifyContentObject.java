package com.spotify.requests.util;

public class SpotifyContentObject {


    private final String uri;


    public SpotifyContentObject(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return String.format("{\"uri\":\"%s\"}", this.uri);
    }


}
