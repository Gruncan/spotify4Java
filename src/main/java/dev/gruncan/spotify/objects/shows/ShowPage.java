package dev.gruncan.spotify.objects.shows;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import lombok.Getter;

@Getter
public class ShowPage extends AbstractSearchItems implements SpotifyObject {


    @SpotifyField
    private SavedShow[] items;

}
