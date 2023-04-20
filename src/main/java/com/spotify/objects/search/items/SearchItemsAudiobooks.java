package com.spotify.objects.search.items;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.audiobooks.Audiobook;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchItemsAudiobooks extends AbstractSearchItems {


    @SpotifyField
    private Audiobook[] items;
}
