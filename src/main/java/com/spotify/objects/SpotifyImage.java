package com.spotify.objects;

public class SpotifyImage implements SpotifyObject {


    @SpotifyField
    private String url;

    @SpotifyNotRequired
    @SpotifyField
    private int height;

    @SpotifyNotRequired
    @SpotifyField
    private int width;


    public String getUrl() {
        return this.url;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    @Override
    public String toString() {
        return "SpotifyImage{" +
                "url='" + url + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
