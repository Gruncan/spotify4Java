package com.spotify.objects.episodes;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.shows.Show;
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
