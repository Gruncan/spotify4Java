package com.spotify.objects.user;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyImage;
import com.spotify.objects.SpotifyObject;

import java.util.Arrays;

public class SpotifyUser implements SpotifyObject {


    @SpotifyField("country")
    private String country;
    @SpotifyField("display_name")
    private String displayName;
    @SpotifyField("email")
    private String email;
    //TODO sort this
    private boolean[] explicitContent;
    @SpotifyField("external_urls")
    private String externalUrlsSpotify;
    @SpotifyField(value = "total", type = Integer.class, path = {"followers"})
    private Integer followers;
    @SpotifyField("href")
    private String href;
    @SpotifyField("id")
    private String id;
    @SpotifyField(value = "images", type = SpotifyImage.class, isArray = true)
    private SpotifyImage[] images;
    @SpotifyField("product")
    private String product;
    @SpotifyField("uri")
    private String uri;



    public String getCountry() {
        return country;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public boolean[] getExplicitContent() {
        return explicitContent;
    }

    public String getExternalUrlsSpotify() {
        return externalUrlsSpotify;
    }

    public int getFollowers() {
        return followers;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public SpotifyImage[] getImages() {
        return images;
    }

    public String getProduct() {
        return product;
    }

    public String getUri() {
        return uri;
    }

    @Override
    public String toString() {
        return "SpotifyUser{" +
                "country='" + country + '\'' +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", explicitContent=" + Arrays.toString(explicitContent) +
                ", externalUrlsSpotify='" + externalUrlsSpotify + '\'' +
                ", followers=" + followers +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + Arrays.toString(images) +
                ", product='" + product + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}

