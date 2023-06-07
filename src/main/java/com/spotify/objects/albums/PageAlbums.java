package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.requests.albums.AlbumReleasesGet;
import lombok.Getter;


/**
 * Represents a spotify page set of albums<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-new-releases">AlbumReleasesGet</a>
 *
 * @see AlbumReleasesGet
 * @see Albums
 * @see SpotifyObject
 */
@Getter
public class PageAlbums implements SpotifyObject {

    /**
     * The albums inner object of the response.
     */
    @SpotifyField
    private Albums albums;

}
