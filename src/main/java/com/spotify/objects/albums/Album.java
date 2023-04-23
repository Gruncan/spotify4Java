/*
 * Written by Gruncan for spotify4Java (https://github.com/Gruncan/spotify4Java/)
 *  21/04/23
 */
package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyOptional;
import com.spotify.objects.artists.Artist;
import com.spotify.objects.artists.SimplifiedArtist;
import com.spotify.requests.albums.AlbumGet;
import com.spotify.objects.tracks.Track;
import lombok.Getter;
import lombok.Setter;


/**
 * Represents a spotify album<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-album">Album</a>
 * @see AlbumGet
 * @see SimplifiedAlbum
 */
@Getter
@Setter
public class Album extends SimplifiedAlbum {


    @SpotifyField
    @SpotifyOptional
    private Artist[] artists;

    @SpotifyField
    @SpotifyOptional
    private Track[] tracks;




}