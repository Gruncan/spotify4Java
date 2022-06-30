package com.spotify.objects.track;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyImage;
import com.spotify.objects.SpotifyNotRequired;
import com.spotify.objects.SpotifyObject;

import java.util.Arrays;

@SpotifyNotRequired
public class TrackArtist implements SpotifyObject {


    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    @SpotifyField(value = "followers", path = {"total"})
    private int followers;
    @SpotifyField
    private String[] genres;
    @SpotifyField
    private String href;
    @SpotifyField
    private String id;
    @SpotifyField
    private SpotifyImage[] images;
    @SpotifyField
    private String name;
    @SpotifyField
    private int popularity;
    @SpotifyField
    private String type;
    @SpotifyField
    private String uri;


    @Override
    public String toString() {
        return "TrackArtist{" +
                "externalUrls=" + externalUrls +
                ", followers=" + followers +
                ", genres=" + Arrays.toString(genres) +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + Arrays.toString(images) +
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
        return images;
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
