package com.spotify.objects.user;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyImage;

import java.io.Serializable;

public class SpotifyUser implements Serializable {


    @SpotifyField("country")
    private final String country;
    @SpotifyField("display_name")
    private final String displayName;
    @SpotifyField("email")
    private final String email;
    //TODO sort this
    private final boolean[] explicitContent;
    @SpotifyField("external_urls")
    private final String externalUrlsSpotify;
    @SpotifyField(value = "followers", type = Integer.class)
    private final int followers;
    @SpotifyField("href")
    private final String href;
    @SpotifyField("id")
    private final String id;
    @SpotifyField(value = "images", type = SpotifyImage.class, isArray = true)
    private final SpotifyImage[] images;
    @SpotifyField("product")
    private final String product;
    @SpotifyField("uri")
    private final String uri;


    public SpotifyUser(String country, String displayName, String email, boolean[] explicitContent,
                       String externalUrlsSpotify, int followers, String href, String id, SpotifyImage[] images,
                       String product, String uri) {
        this.country = country;
        this.displayName = displayName;
        this.email = email;
        this.explicitContent = explicitContent;
        this.externalUrlsSpotify = externalUrlsSpotify;
        this.followers = followers;
        this.href = href;
        this.id = id;
        this.images = images;
        this.product = product;
        this.uri = uri;
    }


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
        return "This is the spotify user";
    }


}

