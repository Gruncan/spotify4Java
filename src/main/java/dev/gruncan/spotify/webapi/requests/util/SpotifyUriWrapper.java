package dev.gruncan.spotify.webapi.requests.util;

public class SpotifyUriWrapper {


    private final SpotifyUriObject uri;

    public SpotifyUriWrapper(SpotifyUriObject uri){
        this.uri = uri;
    }

    @Override
    public String toString() {
        return String.format("{\"uri\":\"%s\"}", this.uri.toString());
    }

}
