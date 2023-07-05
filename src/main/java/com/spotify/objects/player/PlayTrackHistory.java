package com.spotify.objects.player;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.tracks.Track;
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
