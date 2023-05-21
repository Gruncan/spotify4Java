package com.spotify.objects.albums;

import com.spotify.objects.SpotifyField;
import com.spotify.objects.SpotifyObject;
import com.spotify.objects.search.AbstractSearchItems;
import com.spotify.objects.tracks.SimplifiedTrack;
import com.spotify.requests.albums.AlbumTracksGet;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents tracks of an album<br>
 * Serialized from <a href="https://developer.spotify.com/documentation/web-api/reference/get-an-albums-tracks">AlbumTracksGet</a>
 *
 * @see AlbumTracksGet
 * @see AbstractSearchItems
 * @see SimplifiedTrack
 * @see SpotifyObject
 */
@Getter
@Setter
public class AlbumTracks extends AbstractSearchItems implements SpotifyObject {


    /**
     * An array of {@link SimplifiedTrack} for an album
     */
    @SpotifyField
    private SimplifiedTrack[] items;

}
