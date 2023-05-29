package com.spotify.objects.search.items;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.playlists.Playlist;
import com.spotify.objects.search.AbstractSearchItems;
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
