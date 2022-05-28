package com.spotify.objects.track;

import com.spotify.objects.SpotifyImage;
import com.spotify.requests.util.Market;

public class TrackAlbum {


    private final String albumType;
    private final int totalTracks;
    private final Market[] availableMarkets;
    private final Object externalUrls;
    private final String herf;
    private final String id;
    private final SpotifyImage[] images;
    private final String name;
    private final String releaseDate;
    private final String releaseDatePrecision;
    private final Object restrictions;
    private final String type;
    private final String uri;
    private final String albumGroup;
    private final Object[] artists;


    public TrackAlbum(String albumType, int totalTracks, Market[] availableMarkets, Object externalUrls, String herf,
                      String id, SpotifyImage[] images, String name, String releaseDate, String releaseDatePrecision,
                      Object restrictions, String type, String uri, String albumGroup, Object[] artists) {
        this.albumType = albumType;
        this.totalTracks = totalTracks;
        this.availableMarkets = availableMarkets;
        this.externalUrls = externalUrls;
        this.herf = herf;
        this.id = id;
        this.images = images;
        this.name = name;
        this.releaseDate = releaseDate;
        this.releaseDatePrecision = releaseDatePrecision;
        this.restrictions = restrictions;
        this.type = type;
        this.uri = uri;
        this.albumGroup = albumGroup;
        this.artists = artists;
    }
}
