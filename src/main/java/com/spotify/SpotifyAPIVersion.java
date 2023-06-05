package com.spotify;

public enum SpotifyAPIVersion {


    V1("v1");


    private final String version;

    SpotifyAPIVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

    @Override
    public String toString() {
        return this.getVersion();
    }


}
