package dev.gruncan.spotify.api.web.objects.tracks;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.requests.me.tracks.MyTracksGet;
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
