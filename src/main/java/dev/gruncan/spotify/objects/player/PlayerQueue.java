package dev.gruncan.spotify.objects.player;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.episodes.Episode;
import dev.gruncan.spotify.objects.tracks.Track;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PlayerQueue implements SpotifyObject {


    @SpotifyField(value = "currently_playing", canSkip = true)
    private Track track;

    @SpotifyField(value = "currently_playing", canSkip = true)
    private Episode episode;

    @SpotifyField(value = "queue", canSkip = true)
    private Track[] trackQueue;

    @SpotifyField(value = "queue", canSkip = true)
    private Episode[] episodeQueue;

}
