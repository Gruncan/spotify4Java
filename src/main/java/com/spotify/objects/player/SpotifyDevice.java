package com.spotify.objects.player;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import lombok.Getter;

@Getter
public class SpotifyDevice implements SpotifyObject {

    @SpotifyOptional
    @SpotifyField
    private String id;

    @SpotifyField("is_active")
    private boolean isActive;

    @SpotifyField("is_private_session")
    private boolean isPrivateSession;

    @SpotifyField("is_restricted")
    private boolean isRestricted;

    @SpotifyField
    private String name;

    @SpotifyField
    private String type;

    @SpotifyOptional
    @SpotifyField("volume_percent")
    private int volume;

}
