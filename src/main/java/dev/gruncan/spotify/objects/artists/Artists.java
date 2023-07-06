package dev.gruncan.spotify.objects.artists;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.objects.wrappers.SpotifyCursors;
import lombok.Getter;


/**
 * Represents a spotify artists
 *
 * @see PageArtists
 * @see Artist
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class Artists extends AbstractSearchItems implements SpotifyObject {


    /**
     * The cursors used to find the next set of items.
     */
    @SpotifyField
    private SpotifyCursors cursors;

    /**
     * An array of {@link Artists} for an album
     */
    @SpotifyField
    private Artist[] items;




}
