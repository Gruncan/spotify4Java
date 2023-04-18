package com.spotify.objects.search.items;


import com.spotify.objects.SpotifyField;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchItemArtists extends AbstractSearchItems {


    @SpotifyField
    private Artist[] items;

}
