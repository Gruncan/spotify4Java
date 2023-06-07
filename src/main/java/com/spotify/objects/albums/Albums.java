package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
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
