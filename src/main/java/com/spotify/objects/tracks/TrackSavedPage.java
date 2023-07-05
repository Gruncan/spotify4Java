package com.spotify.objects.tracks;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;

@Getter
public class TrackSavedPage extends AbstractSearchItems implements SpotifyObject {

    @SpotifyField
    private SavedTrack[] items;

}
