package com.spotify.objects.search.items;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.tracks.Track;
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
