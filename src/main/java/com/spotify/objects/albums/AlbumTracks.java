/*
 * Written by Gruncan for spotify4Java (https://github.com/Gruncan/spotify4Java/)
 *  21/04/23
 */

package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.requests.albums.AlbumTracksGet;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.tracks.SimplifiedTrack;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the spotify tracks associated with an album<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-albums-tracks">AlbumTracks</a>
 * @see com.spotify.requests.albums.AlbumTracksGet
 * @see com.spotify.objects.search.AbstractSearchItems
 */
@Getter
@Setter
@ToString
public class AlbumTracks extends AbstractSearchItems {


    @SpotifyField
    private SimplifiedTrack[] items;

}
