package dev.gruncan.spotify.objects.player;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.tracks.Track;
import lombok.Getter;

@Getter
public class PlayTrackHistory implements SpotifyObject {


    @SpotifyField
    private Track track;

    @SpotifyField("played_at")
    private String playedAt;

    @SpotifyField
    private PlayerContext context;

}
