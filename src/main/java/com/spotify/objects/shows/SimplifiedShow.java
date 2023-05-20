package com.spotify.objects.shows;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.wrappers.Country;
import com.spotify.objects.wrappers.SpotifyCopyright;
import com.spotify.objects.wrappers.SpotifyImage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedShow implements SpotifyObject {

    @SpotifyField("available_markets")
    private Country[] markets;

    @SpotifyField
    private SpotifyCopyright[] copyrights;

    @SpotifyField
    private String description;

    @SpotifyField("html_description")
    private String htmlDescription;

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

    @SpotifyField
    private String[] languages;

    @SpotifyField("media_type")
    private String mediaType;

    @SpotifyField
    private String name;

    @SpotifyField
    private String publisher;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

    @SpotifyField("total_episodes")
    private int totalEpisodes;
}
