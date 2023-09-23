package dev.gruncan.spotify.api.web.objects.artists;

import dev.gruncan.spotify.api.web.objects.SpotifyField;
import dev.gruncan.spotify.api.web.objects.SpotifyObject;
import dev.gruncan.spotify.api.web.objects.albums.SimplifiedAlbum;
import dev.gruncan.spotify.api.web.objects.search.AbstractSearchItems;
import dev.gruncan.spotify.api.web.requests.artists.ArtistsAlbumsGet;
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
