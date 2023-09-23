package dev.gruncan.spotify.api.web.objects.episodes;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.requests.me.episodes.MyEpisodesGet;
import lombok.Getter;

/**
 * Represents a page of episodes
 *
 * @see MyEpisodesGet
 * @see SavedEpisode
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class EpisodePage extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of SavedEpisodes
     */
    @SpotifyField
    private SavedEpisode[] items;

}
