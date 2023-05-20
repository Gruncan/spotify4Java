package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.wrappers.SpotifyFollowers;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlaylistOwner implements SpotifyObject {


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

    @SpotifyOptional
    @SpotifyField
    private String displayName;


}
