package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.albums.Album;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.wrappers.Country;
import com.spotify.objects.wrappers.SpotifyExternalID;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Track implements SpotifyObject {


    @SpotifyOptional
    @SpotifyField
    private Album album;

    @SpotifyOptional
    @SpotifyField
    private Artist[] artists;

    @SpotifyOptional
    @SpotifyField("available_markets")
    private Country[] markets;

    @SpotifyOptional
    @SpotifyField("disc_number")
    private int discNumber;

    @SpotifyOptional
    @SpotifyField("duration_ms")
    private int duration;

    @SpotifyOptional
    @SpotifyField
    private boolean explicit;

    @SpotifyOptional
    @SpotifyField("external_ids")
    private SpotifyExternalID externalIDs;

    @SpotifyOptional
    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrlsSpotify;

    @SpotifyOptional
    @SpotifyField
    private String href;

    @SpotifyOptional
    @SpotifyField
    private String id;

    @SpotifyOptional
    @SpotifyField("is_playable")
    private boolean isPlayable;

    @SpotifyOptional
    @SpotifyField("linked_form")
    private Object linkedForm;

    @SpotifyOptional
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restrictions;

    @SpotifyOptional
    @SpotifyField
    private String name;

    @SpotifyOptional
    @SpotifyField
    private int popularity;

    @SpotifyOptional
    @SpotifyField("preview_url")
    private String previewURL;

    @SpotifyOptional
    @SpotifyField("track_number")
    private int trackNumber;

    @SpotifyOptional
    @SpotifyField
    private String type;

    @SpotifyOptional
    @SpotifyField
    private String uri;

    @SpotifyOptional
    @SpotifyField("is_local")
    private boolean isLocal;


    @Override
    public String toString() {
        return "Track{" +
                "album=" + album +
                ", artists=" + Arrays.toString(artists) +
                ", markets=" + (this.markets != null ? String.valueOf(markets.length) : "null") +
                ", discNumber=" + discNumber +
                ", duration=" + duration +
                ", explicit=" + explicit +
                ", externalIDs=" + externalIDs +
                ", externalUrlsSpotify=" + externalUrlsSpotify +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", isPlayable=" + isPlayable +
                ", linkedForm=" + linkedForm +
                ", restrictions='" + restrictions + '\'' +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", previewURL='" + previewURL + '\'' +
                ", trackNumber=" + trackNumber +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                ", isLocal=" + isLocal +
                '}';
    }
}