package dev.gruncan.spotify.objects.search.items;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.episodes.Episode;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the results for episodes from a search
 *
 * @see Episode
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
@Setter
public class SearchItemsEpisodes extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link Episode} for a search
     */
    @SpotifyField
    private Episode[] items;

}
