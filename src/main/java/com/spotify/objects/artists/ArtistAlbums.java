package com.spotify.objects.artists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.albums.SimplifiedAlbum;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArtistAlbums extends AbstractSearchItems {


    @SpotifyField
    private SimplifiedAlbum[] items;



}
