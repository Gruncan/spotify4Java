package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.requests.me.albums.MyAlbumsGet;
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
