package dev.gruncan.spotify.objects.albums;

import dev.gruncan.spotify.objects.SpotifyField;
import dev.gruncan.spotify.objects.SpotifyObject;
import dev.gruncan.spotify.objects.SpotifyOptional;
import dev.gruncan.spotify.objects.artists.Artist;
import dev.gruncan.spotify.objects.tracks.Track;
import dev.gruncan.spotify.requests.albums.AlbumGet;
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