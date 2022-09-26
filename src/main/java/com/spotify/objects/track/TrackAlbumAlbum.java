package com.spotify.objects.track;


import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyImage;
import com.spotify.objects.SpotifyNotRequired;
import com.spotify.objects.SpotifyObject;
import com.spotify.requests.util.Market;

//ToDO
public class TrackAlbumAlbum implements SpotifyObject {
    @SpotifyField("album_type")
    private String albumType;

    @SpotifyField("total_tracks")
    private int totalTracks;

    @SpotifyField("available_markets")
    private Market[] availableMarkets;

    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrlsSpotify;

    @SpotifyField
    private String href;

    @SpotifyField
    private String id;

    @SpotifyField
    private SpotifyImage[] images;

    @SpotifyField
    private String name;

    @SpotifyField("release_date")
    private String releaseDate;

    @SpotifyField("release_date_precision")
    private String release_date_precision;

    @SpotifyNotRequired
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restriction;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

    @SpotifyNotRequired
    @SpotifyField("album_group")
    private String albumGroup;

    @SpotifyField
    private TrackArtist[] artists;

}
