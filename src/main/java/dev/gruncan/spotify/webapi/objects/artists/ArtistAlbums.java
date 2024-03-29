package dev.gruncan.spotify.webapi.objects.artists;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.albums.SimplifiedAlbum;
import dev.gruncan.spotify.webapi.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.webapi.requests.artists.ArtistsAlbumsGet;
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
