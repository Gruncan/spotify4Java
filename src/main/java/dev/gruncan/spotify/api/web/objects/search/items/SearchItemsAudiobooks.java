package dev.gruncan.spotify.api.web.objects.search.items;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.audiobooks.Audiobook;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
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
