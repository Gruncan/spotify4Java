package dev.gruncan.spotify.webapi.objects.shows;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.episodes.EpisodesSearch;
import dev.gruncan.spotify.webapi.objects.episodes.SimplifiedEpisode;
import dev.gruncan.spotify.webapi.requests.shows.ShowGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a spotify show
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-a-show">ShowGet</a>
 *
 * @see ShowGet
 * @see SimplifiedShow
 * @see EpisodesSearch
 * @see SpotifyObject
 */
@Getter
@Setter
public class Show extends SimplifiedEpisode implements SpotifyObject {

    /**
     * The episodes of the show
     */
    @SpotifyField
    private EpisodesSearch episodes;
}
