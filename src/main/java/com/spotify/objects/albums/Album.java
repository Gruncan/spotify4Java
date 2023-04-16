package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.artists.SimplifiedArtist;
import com.spotify.objects.wrappers.Market;
import com.spotify.objects.wrappers.SpotifyCopyright;
import com.spotify.objects.wrappers.SpotifyExternalID;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Album implements SpotifyObject {


    @SpotifyField("album_type")
    private String albumType;

    @SpotifyField("total_tracks")
    private int totalTracks;

    @SpotifyField("available_markets")
    private Market[] markets;

    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalIDs;

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
    private String releaseDatePrecision;

    @SpotifyOptional
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restrictions;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

    @SpotifyOptional
    @SpotifyField
    private SpotifyCopyright[] copyrights;

    @SpotifyOptional
    @SpotifyField("external_ids")
    private SpotifyExternalID externalIDS;

    @SpotifyOptional
    @SpotifyField
    private String[] genres;

    @SpotifyOptional
    @SpotifyField
    private String label;

    @SpotifyOptional
    @SpotifyField
    private int popularity;

    @SpotifyOptional
    @SpotifyField("album_group")
    private String albumGroup;

    @SpotifyField("artists")
    private SimplifiedArtist[] simplifiedArtists;


    @Override
    public String toString() {
        return "Album{" +
                "albumType='" + albumType + '\'' +
                ", totalTracks=" + totalTracks +
                ", markets=" + markets.length +
                ", externalIDs='" + externalIDs + '\'' +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + Arrays.toString(images) +
                ", name='" + name + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", releaseDatePrecision='" + releaseDatePrecision + '\'' +
                ", restrictions=" + restrictions +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                ", copyrights=" + Arrays.toString(copyrights) +
                ", externalIDS=" + externalIDS +
                ", genres=" + Arrays.toString(genres) +
                ", label='" + label + '\'' +
                ", popularity=" + popularity +
                ", albumGroup='" + albumGroup + '\'' +
                ", artists='" + Arrays.toString(simplifiedArtists) + '\'' +
                '}';
    }
}