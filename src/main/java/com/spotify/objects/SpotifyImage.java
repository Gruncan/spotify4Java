package com.spotify.objects;

public class SpotifyImage implements SpotifyObject {


    @SpotifyField(value = "url")
    private String url;
    @SpotifyField(value = "height", type = Integer.class, required = false)
    private int height;
    @SpotifyField(value = "width", type = Integer.class, required = false)
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
