package com.spotify.objects.search.items;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.shows.Show;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchItemsShows extends AbstractSearchItems {

    @SpotifyField
    private Show[] items;

}
