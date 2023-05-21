package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.artists.SimplifiedArtist;
import com.spotify.objects.wrappers.Country;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SimplifiedTrack implements SpotifyObject {


    @SpotifyOptional
    @SpotifyField("artists")
    private SimplifiedArtist[] simplifiedArtists;

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




}
