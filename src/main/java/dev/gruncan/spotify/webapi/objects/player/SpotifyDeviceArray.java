package dev.gruncan.spotify.webapi.objects.player;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.requests.me.player.MyPlayerDevicesGet;
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
