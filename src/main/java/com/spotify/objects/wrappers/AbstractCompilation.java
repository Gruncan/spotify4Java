package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.chapters.ChapterResumePoint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCompilation implements SpotifyObject {


    @SpotifyField("audio_preview_url")
    private String audioPreviewUrl;

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

    @SpotifyField
    private String languages;

    @SpotifyField
    private String name;

    @SpotifyField("release_date")
    private String releaseDate;

    @SpotifyField("release_date_precision")
    private String releaseDatePrecision;

    @SpotifyField("resume_point")
    private ChapterResumePoint resumePoint;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

    @SpotifyOptional
    @SpotifyField(value = "reason", path = {"restrictions"})
    private String restrictions;
}
