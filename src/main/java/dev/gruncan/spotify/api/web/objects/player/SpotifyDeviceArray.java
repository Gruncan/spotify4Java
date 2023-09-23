package dev.gruncan.spotify.api.web.objects.player;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.requests.me.player.MyPlayerDevicesGet;
import lombok.Getter;

/**
 * Represents a set of devices
 *
 * @see MyPlayerDevicesGet
 * @see SpotifyDevice
 * @see SpotifyObject
 */
@Getter
public class SpotifyDeviceArray implements SpotifyObject {

    /**
     * The set of spotify devices
     */
    @SpotifyField
    private SpotifyDevice[] devices;

}
