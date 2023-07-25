package dev.gruncan.spotify.webapi.objects.albums;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.search.AbstractSearchItems;
import lombok.Getter;

/**
 * Represents a spotify albums
 *
 * @see PageAlbums
 * @see SimplifiedAlbum
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class Albums extends AbstractSearchItems implements SpotifyObject {


    /**
     * An array of {@link SimplifiedAlbum} for an album
     */
    @SpotifyField
    private SimplifiedAlbum[] items;

}
