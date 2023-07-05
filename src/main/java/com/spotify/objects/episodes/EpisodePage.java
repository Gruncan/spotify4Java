package com.spotify.objects.episodes;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;

@Getter
public class EpisodePage extends AbstractSearchItems implements SpotifyObject {

    @SpotifyField
    private SavedEpisode[] items;

}
