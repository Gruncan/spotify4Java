package dev.gruncan.spotify.api.web.objects.player;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.SpotifyOptional;
import dev.gruncan.spotify.api.web.objects.episodes.Episode;
import dev.gruncan.spotify.api.web.objects.tracks.Track;
import dev.gruncan.spotify.api.web.requests.me.player.MyPlayerCurrentlyPlayingGet;
import dev.gruncan.spotify.api.web.requests.me.player.MyPlayerGet;
import lombok.Getter;

/**
 * Represents information about playback
 *
 * @see MyPlayerGet
 * @see MyPlayerCurrentlyPlayingGet
 * @see SpotifyDevice
 * @see PlayerContext
 * @see Track
 * @see Episode
 * @see PlayerActions
 * @see SpotifyObject
 */
@Getter
public class PlaybackState implements SpotifyObject {

    /**
     * The device that is currently active.
     */
    @SpotifyField
    private SpotifyDevice device;

    /**
     * off, track, context
     */
    @SpotifyField("repeat_state")
    private String repeatState;

    /**
     * If shuffle is on or off.
     */
    @SpotifyField("shuffle_state")
    private boolean isShuffled;

    /**
     * A Context Object. Can be null.
     */
    @SpotifyOptional
    @SpotifyField
    private PlayerContext context;

    /**
     * Unix Millisecond Timestamp when data was fetched.
     */
    @SpotifyField
    private int timestamp;

    /**
     * Progress into the currently playing track or episode. Can be null.
     */
    @SpotifyField("progress_ms")
    private int progress;

    /**
     * The currently playing track if present
     */
    @SpotifyOptional
    @SpotifyField(value = "item", canSkip = true)
    private Track track;

    /**
     * The currently playing episode if present
     */
    @SpotifyOptional
    @SpotifyField(value = "item", canSkip = true)
    private Episode episode;

    /**
     * The object type of the currently playing item. Can be one of track, episode, ad or unknown.
     */
    @SpotifyField("currently_playing_type")
    private String currentlyPlayingType;

    /**
     * Allows to update the user interface based on which playback actions are available within the current context.
     */
    @SpotifyField
    private PlayerActions actions;

}
