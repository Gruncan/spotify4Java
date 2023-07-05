package com.spotify.objects.player;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.episodes.Episode;
import com.spotify.objects.tracks.Track;
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
