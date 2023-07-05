package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.player.PlayTrackHistory;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.wrappers.SpotifyCursors;
import lombok.Getter;


@Getter
public class TrackPage extends AbstractSearchItems implements SpotifyObject {


    @SpotifyField
    private SpotifyCursors cursors;

    @SpotifyField
    private PlayTrackHistory items;

}
