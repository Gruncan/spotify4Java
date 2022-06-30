package com.spotify.objects.user;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyImage;
import com.spotify.objects.SpotifyNotRequired;
import com.spotify.objects.SpotifyObject;

import java.util.Arrays;

@SpotifyNotRequired
public class SpotifyUser implements SpotifyObject {


    @SpotifyField
    private String country;
    @SpotifyField("display_name")
    private String displayName;
    @SpotifyField("email")
    private String email;
    //TODO sort this
    private boolean[] explicitContent;
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrlsSpotify;
    @SpotifyField(value = "total", path = {"followers"})
    private Integer followers;
    @SpotifyField
    private String href;
    @SpotifyField
    private String id;
    @SpotifyField
    private SpotifyImage[] images;
    @SpotifyField
    private String product;
    @SpotifyField
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

