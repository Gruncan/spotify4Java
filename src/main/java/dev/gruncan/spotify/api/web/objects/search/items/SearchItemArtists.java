package dev.gruncan.spotify.api.web.objects.search.items;


import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.artists.Artist;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
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
