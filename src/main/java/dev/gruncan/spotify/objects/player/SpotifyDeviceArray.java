package dev.gruncan.spotify.objects.player;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.requests.me.player.MyPlayerDevicesGet;
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
