package com.spotify.objects.search.items;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.episodes.Episode;
import com.spotify.objects.search.AbstractSearchItems;
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
