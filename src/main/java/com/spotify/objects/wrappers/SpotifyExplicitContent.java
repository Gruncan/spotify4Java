package com.spotify.objects.wrappers;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.user.Profile;
import lombok.Getter;

/**
 * Represents the user's explicit content settings.
 *
 * @see Profile
 * @see SpotifyObject
 *
 */
@Getter
@SpotifyOptional
public class SpotifyExplicitContent implements SpotifyObject {

    /**
     * When true, indicates that explicit content should not be played.
     */
    @SpotifyField("filter_enabled")
    private boolean filterEnabled;

    /**
     * When true, indicates that the explicit content setting is locked and can't be changed by the user.
     */
    @SpotifyField("filter_locked")
    private boolean filterLocked;

}
