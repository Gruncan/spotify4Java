package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.wrappers.SpotifyFollowers;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistContributor implements SpotifyObject {

    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    @SpotifyField
    private SpotifyFollowers followers;

    @SpotifyField
    private String href;

    @SpotifyField
    private String id;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

}
