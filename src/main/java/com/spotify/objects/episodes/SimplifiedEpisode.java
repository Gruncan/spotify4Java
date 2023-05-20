package com.spotify.objects.episodes;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.chapters.ChapterResumePoint;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedEpisode implements SpotifyObject {

    @SpotifyField("audio_preview_url")
    private String audioPreviewUrl;

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

    @SpotifyField("is_externally_hosted")
    private boolean isExternallyHosted;

    @SpotifyField("is_playable")
    private boolean isPlayable;

    @SpotifyField
    private String[] languages;

    @SpotifyField
    private String name;

    @SpotifyField("release_date")
    private String releaseDate;

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
