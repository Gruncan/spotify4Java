package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.tracks.Track;
import com.spotify.requests.albums.AlbumGet;
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