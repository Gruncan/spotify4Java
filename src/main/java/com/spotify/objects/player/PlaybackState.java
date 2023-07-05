package com.spotify.objects.player;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.episodes.Episode;
import com.spotify.objects.tracks.Track;
import lombok.Getter;

@Getter
public class PlaybackState implements SpotifyObject {

    @SpotifyField
    private SpotifyDevice device;

    @SpotifyField("repeat_state")
    private String repeatState;

    @SpotifyField("shuffle_state")
    private boolean isShuffled;

    @SpotifyOptional
    @SpotifyField
    private PlayerContext context;

    @SpotifyField
    private int timestamp;

    @SpotifyField("progress_ms")
    private int progress;

    @SpotifyOptional
    @SpotifyField("item")
    private Track track;

    @SpotifyOptional
    @SpotifyField("item")
    private Episode episode;

    @SpotifyField("currently_playing_type")
    private String currentlyPlayingType;

    @SpotifyField
    private PlayerActions actions;

}
