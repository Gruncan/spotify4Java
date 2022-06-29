package com.spotify.objects.track;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyImage;
import com.spotify.objects.SpotifyObject;

import java.util.Arrays;


public class TrackArtist implements SpotifyObject {


    @SpotifyField(value = "spotify", path = {"external_urls"}, required = false)
    private String externalUrls;
    @SpotifyField(value = "followers", path = {"total"}, required = false)
    private int followers;
    @SpotifyField(value = "genres", required = false)
    private String[] genres;
    @SpotifyField(value = "href", required = false)
    private String href;
    @SpotifyField(value = "id", required = false)
    private String id;
    @SpotifyField(value = "images", required = false)
    private SpotifyImage[] image;
    @SpotifyField(value = "name", required = false)
    private String name;
    @SpotifyField(value = "popularity", required = false)
    private int popularity;
    @SpotifyField(value = "type", required = false)
    private String type;
    @SpotifyField(value = "uri", required = false)
    private String uri;


    @Override
    public String toString() {
        return "TrackArtist{" +
                "externalUrls=" + externalUrls +
                ", followers=" + followers +
                ", genres=" + Arrays.toString(genres) +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + Arrays.toString(image) +
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

    public SpotifyImage[] getImage() {
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
