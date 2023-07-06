package dev.gruncan.spotify.objects.player;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.SpotifyOptional;
import dev.gruncan.spotify.objects.episodes.Episode;
import dev.gruncan.spotify.objects.tracks.Track;
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
