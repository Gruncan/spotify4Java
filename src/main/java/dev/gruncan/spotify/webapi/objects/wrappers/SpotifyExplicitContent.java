package dev.gruncan.spotify.webapi.objects.wrappers;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import dev.gruncan.spotify.webapi.objects.user.Profile;
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
