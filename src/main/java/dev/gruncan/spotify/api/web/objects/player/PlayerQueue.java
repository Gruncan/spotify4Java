package dev.gruncan.spotify.api.web.objects.player;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.episodes.Episode;
import dev.gruncan.spotify.api.web.objects.tracks.Track;
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
