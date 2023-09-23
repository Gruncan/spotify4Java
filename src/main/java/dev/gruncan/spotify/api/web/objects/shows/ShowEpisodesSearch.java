package dev.gruncan.spotify.api.web.objects.shows;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.episodes.SimplifiedEpisode;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.requests.shows.ShowEpisodesGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the episodes of a show
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-shows-episodes">ShowEpisodesGet</a>
 *
 * @see ShowEpisodesGet
 * @see AbstractSearchItems
 * @see SimplifiedEpisode
 * @see SpotifyObject
 */
@Getter
@Setter
public class ShowEpisodesSearch extends AbstractSearchItems implements SpotifyObject {

    @SpotifyField
    private SimplifiedEpisode[] items;

}
