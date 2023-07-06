package dev.gruncan.spotify.objects.tracks;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.player.PlayTrackHistory;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.objects.wrappers.SpotifyCursors;
import lombok.Getter;


@Getter
public class TrackPage extends AbstractSearchItems implements SpotifyObject {


    @SpotifyField
    private SpotifyCursors cursors;

    @SpotifyField
    private PlayTrackHistory items;

}
