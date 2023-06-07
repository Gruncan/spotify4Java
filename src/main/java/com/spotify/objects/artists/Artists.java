package com.spotify.objects.artists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.wrappers.SpotifyCursors;
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
