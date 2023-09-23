package dev.gruncan.spotify.api.web.objects.player;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.SpotifyOptional;
import lombok.Getter;

/**
 * Represents the action available within the current context
 *
 * @see PlaybackState
 * @see SpotifyObject
 */
@Getter
@SpotifyOptional
public class PlayerActions implements SpotifyObject {

    /**
     * Interrupting playback
     */
    @SpotifyField("interrupting_playback")
    private boolean isInterruptingPlayback;

    /**
     * Pausing
     */
    @SpotifyField("pausing")
    private boolean isPausing;

    /**
     * Resuming
     */
    @SpotifyField("resuming")
    private boolean isResuming;

    /**
     * Seeking playback location
     */
    @SpotifyField("seeking")
    private boolean isSeeking;

    /**
     * Skipping to the next context
     */
    @SpotifyField("skipping_next")
    private boolean isSkippingNext;

    /**
     * Skipping to the previous context
     */
    @SpotifyField("skipping_prev")
    private boolean isSkippingPrev;

    /**
     * Toggling repeat context flag
     */
    @SpotifyField("toggling_repeat_context")
    private boolean isTogglingRepeatContext;

    /**
     * Toggling shuffle flag
     */
    @SpotifyField("toggling_shuffle")
    private boolean isTogglingShuffle;

    /**
     * Toggling repeat track flag
     */
    @SpotifyField("toggling_repeat_track")
    private boolean isTogglingRepeatTrack;

    /**
     * Transferring playback between devices
     */
    @SpotifyField("transferring_playback")
    private boolean isTransferringPlayback;

}
