package dev.gruncan.spotify.api.web.objects.search.items;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.playlists.Playlist;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the results for playlist from a search
 *
 * @see Playlist
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
@Setter
public class SearchItemsPlaylists extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link Playlist} for a search
     */
    @SpotifyField
    private Playlist[] items;

}
