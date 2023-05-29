package com.spotify.objects.search.items;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.shows.Show;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the results for shows from a search
 *
 * @see Show
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
@Setter
public class SearchItemsShows extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link Show} for a search
     */
    @SpotifyField
    private Show[] items;

}
