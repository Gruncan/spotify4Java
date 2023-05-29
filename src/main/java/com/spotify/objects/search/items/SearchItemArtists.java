package com.spotify.objects.search.items;


import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the results for artists from a search
 *
 * @see Artist
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
@Setter
public class SearchItemArtists extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link Artist} for a search
     */
    @SpotifyField
    private Artist[] items;

}
