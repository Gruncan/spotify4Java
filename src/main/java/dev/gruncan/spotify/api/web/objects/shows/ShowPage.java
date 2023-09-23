package dev.gruncan.spotify.api.web.objects.shows;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.requests.me.shows.MyShowsGet;
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
