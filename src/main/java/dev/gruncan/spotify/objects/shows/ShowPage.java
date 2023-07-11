package dev.gruncan.spotify.objects.shows;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.requests.me.shows.MyShowsGet;
import lombok.Getter;

/**
 * Represents a show page
 *
 * @see MyShowsGet
 * @see SavedShow
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class ShowPage extends AbstractSearchItems implements SpotifyObject {

    /**
     * The array of SavedShows
     */
    @SpotifyField
    private SavedShow[] items;

}
