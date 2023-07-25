package dev.gruncan.spotify.webapi.objects.albums;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.webapi.requests.me.albums.MyAlbumsGet;
import lombok.Getter;

/**
 * Represents a spotify saved albums<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-users-saved-albums">MyAlbumsGet</a>
 *
 * @see MyAlbumsGet
 * @see SavedAlbum
 * @see AbstractSearchItems
 * @see SpotifyObject
 */
@Getter
public class SavedAlbums extends AbstractSearchItems implements SpotifyObject {

    /**
     * An array of {@link SavedAlbum} for an album
     */
    @SpotifyField
    private SavedAlbum[] items;

}
