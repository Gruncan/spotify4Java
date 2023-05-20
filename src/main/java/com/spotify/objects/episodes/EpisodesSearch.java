package com.spotify.objects.episodes;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodesSearch extends AbstractSearchItems {

    @SpotifyField
    private SimplifiedEpisode[] episodes;

}
