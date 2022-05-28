package com.spotify.objects.track;

import com.spotify.objects.SpotifyImage;

public class TrackArtist {


    private final Object externalUrls;
    private final int followers;
    private final String[] genres;
    private final String href;
    private final String id;
    private final SpotifyImage[] images;
    private final String name;
    private final int popularity;
    private final String type;
    private final String uri;


    public TrackArtist(Object externalUrls, int followers, String[] genres, String href, String id, SpotifyImage[] images, String name, int popularity, String type, String uri) {
        this.externalUrls = externalUrls;
        this.followers = followers;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.popularity = popularity;
        this.type = type;
        this.uri = uri;
    }
}
