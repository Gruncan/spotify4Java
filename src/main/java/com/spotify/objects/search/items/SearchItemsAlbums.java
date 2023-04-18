package com.spotify.objects.search.items;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.albums.Album;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchItemsAlbums extends AbstractSearchItems {

    @SpotifyField
    private Album[] items;

}
