package com.spotify.objects.track;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyImage;
import com.spotify.objects.SpotifyNotRequired;
import com.spotify.objects.SpotifyObject;

public class TrackArtist implements SpotifyObject {

    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrlsSpotify;

    @SpotifyField
    private String href;

    @SpotifyField
    private String id;

    @SpotifyField
    private String name;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;


    @SpotifyNotRequired
    @SpotifyField
    private SpotifyImage[] images;

    @SpotifyNotRequired
    @SpotifyField
    private int popularity;

    @SpotifyNotRequired
    @SpotifyField
    private Follower followers;

    private static class Follower implements SpotifyObject {

        @SpotifyField
        private String href;

        @SpotifyField
        private int total;


    }


}
