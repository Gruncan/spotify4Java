package dev.gruncan.spotify.webapi.objects.player;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import lombok.Getter;


/**
 * Represents a spotify device
 *
 * @see SpotifyDeviceArray
 * @see SpotifyObject
 */
@Getter
public class SpotifyDevice implements SpotifyObject {

    /**
     * The device ID.
     */
    @SpotifyOptional
    @SpotifyField
    private String id;

    /**
     * If this device is the currently active device.
     */
    @SpotifyField("is_active")
    private boolean isActive;

    /**
     * If this device is currently in a private session.
     */
    @SpotifyField("is_private_session")
    private boolean isPrivateSession;

    /**
     * Whether controlling this device is restricted. At present if this is "true" then no Web API commands will be accepted by this device.
     */
    @SpotifyField("is_restricted")
    private boolean isRestricted;

    /**
     * A human-readable name for the device. Some devices have a name that the user can configure (e.g. "Loudest speaker") and some devices have a generic name associated with the manufacturer or device model.
     */
    @SpotifyField
    private String name;

    /**
     * Device type, such as "computer", "smartphone" or "speaker".
     */
    @SpotifyField
    private String type;

    /**
     * The current volume in percent.
     */
    @SpotifyOptional
    @SpotifyField("volume_percent")
    private int volume;

}
