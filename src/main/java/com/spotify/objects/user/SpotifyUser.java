package com.spotify.objects.user;

import com.spotify.objects.ISerializable;
import com.spotify.objects.SpotifyImage;

public class SpotifyUser implements ISerializable {


    private final String country;
    private final String displayName;
    private final String email;
    private final boolean[] explicitContent;
    private final String externalUrlsSpotify;
    private final int followers;
    private final String href;
    private final String id;
    private final SpotifyImage[] images;
    private final String product;
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

