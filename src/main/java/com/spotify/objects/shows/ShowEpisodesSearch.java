package com.spotify.objects.shows;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.episodes.SimplifiedEpisode;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowEpisodesSearch extends AbstractSearchItems {

    @SpotifyField
    private SimplifiedEpisode[] items;

}
