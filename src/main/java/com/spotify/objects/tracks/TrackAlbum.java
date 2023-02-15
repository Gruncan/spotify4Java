package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.requests.util.Market;

import java.util.Arrays;

public class TrackAlbum implements SpotifyObject {


    @SpotifyField
    private TrackAlbumAlbum album;

    @SpotifyNotRequired
    @SpotifyField
    private TrackArtist[] artists;

    @SpotifyNotRequired
    @SpotifyField("available_markets")
    private Market[] availableMarkets;

    @SpotifyNotRequired
    @SpotifyField("disc_number")
    private int discNumber;

    @SpotifyNotRequired
    @SpotifyField("duration_ms")
    private int durationMs;

    @SpotifyNotRequired
    @SpotifyField
    private boolean explicit;

    @SpotifyNotRequired
    @SpotifyField("external_ids")
    private ExternalIds externalIds;

    @SpotifyNotRequired
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrlsSpotify;

    @SpotifyNotRequired
    @SpotifyField
    private String href;

    @SpotifyNotRequired
    @SpotifyField
    private String id;

    @SpotifyNotRequired
    @SpotifyField("is_playable")
    private boolean isPlayable;

    @SpotifyNotRequired
    @SpotifyField("linked_from")
    private Object todo;

    @SpotifyNotRequired
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restriction;

    @SpotifyNotRequired
    @SpotifyField
    private String name;

    @SpotifyNotRequired
    @SpotifyField
    private int popularity;

    @SpotifyNotRequired
    @SpotifyField("preview_url")
    private String previewUrl;

    @SpotifyNotRequired
    @SpotifyField("track_number")
    private int trackNumber;

    @SpotifyNotRequired
    @SpotifyField
    private String type;

    @SpotifyNotRequired
    @SpotifyField
    private String uri;

    @SpotifyNotRequired
    @SpotifyField("is_local")
    private boolean isLocal;


    @Override
    public String toString() {
        return "TrackAlbum{" +
                "album=" + album +
                ", artists=" + Arrays.toString(artists) +
                ", availableMarkets=" + Arrays.toString(availableMarkets) +
                ", discNumber=" + discNumber +
                ", durationMs=" + durationMs +
                ", explicit=" + explicit +
                ", externalIds=" + externalIds +
                ", externalUrlsSpotify='" + externalUrlsSpotify + '\'' +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", isPlayable=" + isPlayable +
                ", todo=" + todo +
                ", restriction='" + restriction + '\'' +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", previewUrl='" + previewUrl + '\'' +
                ", trackNumber=" + trackNumber +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                ", isLocal=" + isLocal +
                '}';
    }
}