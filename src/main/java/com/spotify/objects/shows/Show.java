package com.spotify.objects.shows;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.episodes.EpisodesSearch;
import com.spotify.objects.episodes.SimplifiedEpisode;
import com.spotify.requests.shows.ShowGet;
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
