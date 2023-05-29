package com.spotify.objects.search.items;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.albums.Album;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the results for albums from a search
 *
 * @see Album
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
@Setter
public class SearchItemsAlbums extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link Album} for a search
     */
    @SpotifyField
    private Album[] items;

}
