package dev.gruncan.spotify.webapi.objects.search.items;


import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.artists.Artist;
import dev.gruncan.spotify.webapi.objects.search.AbstractSearchItems;
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
