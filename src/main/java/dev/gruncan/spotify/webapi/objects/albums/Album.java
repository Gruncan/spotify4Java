package dev.gruncan.spotify.webapi.objects.albums;

import dev.gruncan.spotify.webapi.objects.SpotifyField;
import dev.gruncan.spotify.webapi.objects.SpotifyObject;
import dev.gruncan.spotify.webapi.objects.SpotifyOptional;
import dev.gruncan.spotify.webapi.objects.artists.Artist;
import dev.gruncan.spotify.webapi.objects.tracks.Track;
import dev.gruncan.spotify.webapi.requests.albums.AlbumGet;
import lombok.Getter;
import lombok.Setter;


/**
 * Represents a spotify album<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-album">AlbumGet</a>
 *
 * @see AlbumGet
 * @see SimplifiedAlbum
 * @see SpotifyObject
 */
@Getter
@Setter
public class Album extends SimplifiedAlbum implements SpotifyObject {

    /**
     * The artists of the album. Each artist object includes a link in href to more detailed information about the artist.
     */
    @SpotifyField
    @SpotifyOptional
    private Artist[] artists;

    /**
     * The tracks of the album.
     */
    @SpotifyField
    @SpotifyOptional
    private Track[] tracks;


}