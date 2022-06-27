package com.spotify.objects;

public class SpotifyImage implements SpotifyObject {


    @SpotifyField(value = "url")
    private final String url;
    @SpotifyField(value = "height", type = Integer.class, required = false)
    private final int height;
    @SpotifyField(value = "width", type = Integer.class, required = false)
    private final int width;

    public SpotifyImage(String url) {
        this(url, -1, -1);
    }

    public SpotifyImage(String url, int height, int width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }

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
