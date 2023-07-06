package dev.gruncan.spotify.objects.tracks;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;

@Getter
public class TrackSavedPage extends AbstractSearchItems implements SpotifyObject {

    @SpotifyField
    private SavedTrack[] items;

}
