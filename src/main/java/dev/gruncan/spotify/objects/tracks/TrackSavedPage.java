package dev.gruncan.spotify.objects.tracks;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.requests.me.tracks.MyTracksGet;
import lombok.Getter;

/**
 * Represents a saved track page
 *
 * @see MyTracksGet
 * @see SavedTrack
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class TrackSavedPage extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of SavedTracks
     */
    @SpotifyField
    private SavedTrack[] items;

}
