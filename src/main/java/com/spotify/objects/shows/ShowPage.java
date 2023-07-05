package com.spotify.objects.shows;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;

@Getter
public class ShowPage extends AbstractSearchItems implements SpotifyObject {


    @SpotifyField
    private SavedShow[] items;

}
