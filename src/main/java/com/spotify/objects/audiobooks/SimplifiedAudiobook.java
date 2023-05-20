package com.spotify.objects.audiobooks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.wrappers.SpotifyCopyright;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedAudiobook implements SpotifyObject {

    @SpotifyField
    private AudiobookAuthor[] authors;

    @SpotifyField("available_markets")
    private String[] availableMarkets;

    @SpotifyField
    private SpotifyCopyright[] copyrights;

    @SpotifyField
    private String description;

    @SpotifyField("html_description")
    private String htmlDescription;

    @SpotifyField
    @SpotifyOptional
    private String edition;

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
    private String[] languages;

    @SpotifyField("media_type")
    private String mediaType;

    @SpotifyField
    private String name;

    @SpotifyField
    private AudiobookNarrator[] narrators;

    @SpotifyField
    private String publisher;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

    @SpotifyField("total_chapters")
    private int totalChapters;

}
