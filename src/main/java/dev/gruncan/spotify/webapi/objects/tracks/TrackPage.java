package dev.gruncan.spotify.webapi.objects.tracks;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.player.PlayTrackHistory;
import dev.gruncan.spotify.webapi.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.webapi.objects.wrappers.SpotifyCursors;
import dev.gruncan.spotify.webapi.requests.me.player.MyPlayerRecentlyPlayedGet;
import lombok.Getter;


/**
 * Represents a track page
 *
 * @see MyPlayerRecentlyPlayedGet
 * @see SpotifyCursors
 * @see PlayTrackHistory
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class TrackPage extends AbstractSearchItems implements SpotifyObject {

    /**
     * The cursors used to find the next set of items.
     */
    @SpotifyField
    private SpotifyCursors cursors;

    /**
     * The play history of the tracks
     */
    @SpotifyField
    private PlayTrackHistory items;

}
