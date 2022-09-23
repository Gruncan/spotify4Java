package com.spotify.objects.track;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyNotRequired;
import com.spotify.objects.SpotifyObject;
import com.spotify.requests.util.ExternalIds;
import com.spotify.requests.util.Market;

public class TrackAlbum implements SpotifyObject {


    @SpotifyField
    private TrackAlbum album;

    @SpotifyField
    private TrackArtist[] artists;

    @SpotifyField("available_markets")
    private Market[] availableMarkets;

    @SpotifyField("disc_number")
    private int discNumber;

    @SpotifyField("duration_ms")
    private int durationMs;

    @SpotifyField
    private boolean explicit;

    @SpotifyNotRequired
    @SpotifyField("external_ids")
    private ExternalIds externalIds;

    @SpotifyNotRequired
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrlsSpotify;

    @SpotifyField
    private String href;

    @SpotifyField
    private String id;

    @SpotifyField("is_playable")
    private boolean isPlayable;

    @SpotifyNotRequired
    @SpotifyField("linked_from")
    private Object todo;

    @SpotifyNotRequired
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restriction;

    @SpotifyField
    private String name;

    @SpotifyField
    private int popularity;

    @SpotifyField("preview_url")
    private String previewUrl;

    @SpotifyField("track_number")
    private int trackNumber;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

    @SpotifyField("is_local")
    private boolean isLocal;
}
