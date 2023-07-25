package dev.gruncan.spotify.webapi.objects.search.items;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.albums.Album;
import dev.gruncan.spotify.webapi.objects.search.AbstractSearchItems;
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
