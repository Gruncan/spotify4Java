package dev.gruncan.spotify.webapi.requests.util;

public class SpotifyPositionObject {



    private final int position;


    public SpotifyPositionObject(int position){
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("\"position\": %s", this.position);
    }
}
