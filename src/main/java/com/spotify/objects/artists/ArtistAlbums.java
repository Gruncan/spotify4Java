package com.spotify.objects.artists;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.albums.SimplifiedAlbum;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.requests.artists.ArtistsAlbumsGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents albums of an artists<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-artists-albums">ArtistsAlbumsGet</a>
 *
 * @see ArtistsAlbumsGet
 * @see AbstractSearchItems
 * @see SimplifiedAlbum
 * @see SpotifyObject
 */
@Getter
@Setter
public class ArtistAlbums extends AbstractSearchItems implements SpotifyObject {


    /**
     * An array of {@link SimplifiedAlbum} for an artists
     */
    @SpotifyField
    private SimplifiedArtistAlbum[] items;


}
