package dev.gruncan.spotify.api.web.objects.episodes;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.objects.shows.Show;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents episodes of a show
 *
 * @see Show
 * @see AbstractSearchItems
 * @see SimplifiedEpisode
 * @see SpotifyObject
 */
@Getter
@Setter
public class EpisodesSearch extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link SimplifiedEpisode} for an album
     */
    @SpotifyField
    private SimplifiedEpisode[] episodes;

}
