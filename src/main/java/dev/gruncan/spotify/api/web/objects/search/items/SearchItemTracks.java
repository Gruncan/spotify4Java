package dev.gruncan.spotify.api.web.objects.search.items;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.objects.tracks.Track;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the results for tracks from a search
 *
 * @see Track
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
@Setter
public class SearchItemTracks extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link Track} for a search
     */
    @SpotifyField
    private Track[] items;

}
