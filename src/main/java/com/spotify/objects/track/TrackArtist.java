package com.spotify.objects.track;

import com.spotify.objects.SpotifyImage;

import java.util.Arrays;

public class TrackArtist {


    private final Object externalUrls;
    private final int followers;
    private final String[] genres;
    private final String href;
    private final String id;
    private final SpotifyImage image;
    private final String name;
    private final int popularity;
    private final String type;
    private final String uri;


    public TrackArtist(String externalUrls, int followers, String[] genres, String href, String id, SpotifyImage image, String name, int popularity, String type, String uri) {
        this.externalUrls = externalUrls;
        this.followers = followers;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.image = image;
        this.name = name;
        this.popularity = popularity;
        this.type = type;
        this.uri = uri;
    }


    @Override
    public String toString() {
        return "TrackArtist{" +
                "externalUrls=" + externalUrls +
                ", followers=" + followers +
                ", genres=" + Arrays.toString(genres) +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", image=" + image +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    public Object getExternalUrls() {
        return externalUrls;
    }

    public int getFollowers() {
        return followers;
    }

    public String[] getGenres() {
        return genres;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public SpotifyImage getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
