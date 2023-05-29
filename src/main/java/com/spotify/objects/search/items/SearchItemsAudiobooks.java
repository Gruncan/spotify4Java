package com.spotify.objects.search.items;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.audiobooks.Audiobook;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the results for audiobooks from a search
 *
 * @see Audiobook
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
@Setter
public class SearchItemsAudiobooks extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link Audiobook} for a search
     */
    @SpotifyField
    private Audiobook[] items;
}
