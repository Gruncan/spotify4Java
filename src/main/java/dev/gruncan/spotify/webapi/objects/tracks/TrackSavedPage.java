package dev.gruncan.spotify.webapi.objects.tracks;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.webapi.requests.me.tracks.MyTracksGet;
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
