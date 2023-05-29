package com.spotify.objects.shows;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.episodes.SimplifiedEpisode;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.requests.shows.ShowEpisodesGet;
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
