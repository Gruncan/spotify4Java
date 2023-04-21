package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.wrappers.Country;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimplifiedChapter implements SpotifyObject {

    @SpotifyField("audio_preview_url")
    private String audioPreviewUrl;

    @SpotifyOptional
    @SpotifyField("available_markets")
    private Country[] markets;

    @SpotifyField("chapter_number")
    private int chapterNumber;

    @SpotifyField
    private String description;

    @SpotifyField("html_description")
    private String htmlDescription;

    @SpotifyField("duration_ms")
    private int duration;

    @SpotifyField
    private boolean explicit;

    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    @SpotifyField
    private String href;

    @SpotifyField
    private String id;

    @SpotifyField
    private SpotifyImage[] images;

    @SpotifyField("is_playable")
    private boolean isPlayable;

    @SpotifyField
    private String[] languages;

    @SpotifyField
    private String name;

    @SpotifyField("release_date")
    private String releaseDate;

    @SpotifyField
    private String uri;

    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restrictions;
}
