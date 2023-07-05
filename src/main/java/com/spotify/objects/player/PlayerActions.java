package com.spotify.objects.player;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import lombok.Getter;

@Getter
public class PlayerActions implements SpotifyObject {


    @SpotifyField("interrupting_playback")
    private boolean isInterruptingPlayback;

    @SpotifyField("pausing")
    private boolean isPausing;

    @SpotifyField("resuming")
    private boolean isResuming;

    @SpotifyField("seeking")
    private boolean isSeeking;

    @SpotifyField("skipping_next")
    private boolean isSkippingNext;

    @SpotifyField("skipping_prev")
    private boolean isSkippingPrev;

    @SpotifyField("toggling_repeat_context")
    private boolean isTogglingRepeatContext;

    @SpotifyField("toggling_shuffle")
    private boolean isTogglingShuffle;

    @SpotifyField("toggling_repeat_track")
    private boolean isTogglingRepeatTrack;

    @SpotifyField("transferring_playback")
    private boolean isTransferringPlayback;

}
