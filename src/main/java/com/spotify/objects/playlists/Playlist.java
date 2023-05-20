package com.spotify.objects.playlists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.wrappers.SpotifyFollowers;
import com.spotify.objects.wrappers.SpotifyImage;

public class Playlist implements SpotifyObject {


    @SpotifyField("collaborative")
    private boolean isCollaborative;

    @SpotifyOptional
    @SpotifyField
    private String description;

    @SpotifyField(value = "spotify", path = {"external_urls"})
    private String externalUrls;

    @SpotifyField
    private SpotifyFollowers followers;

    @SpotifyField
    private String href;

    @SpotifyField
    private String id;

    @SpotifyField
    private SpotifyImage[] images;

    @SpotifyField
    private String name;

    @SpotifyField
    private PlaylistOwner owner;

    @SpotifyField("is_public")
    private boolean isPublic;

    @SpotifyField("snapshot_id")
    private String snapshotID;

    @SpotifyField
    private PlaylistTracksSearch tracks;

    @SpotifyField
    private String type;

    @SpotifyField
    private String uri;

}
