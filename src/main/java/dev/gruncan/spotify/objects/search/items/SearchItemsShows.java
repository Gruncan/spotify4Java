package dev.gruncan.spotify.objects.search.items;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.objects.shows.Show;
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
